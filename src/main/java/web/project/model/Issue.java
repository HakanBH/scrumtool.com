package web.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "issues")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Issue implements Comparable<Issue>{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String summary;

    @Column
    private String description;

    @Column
    private String status;

    @Column
    private String type;

    @Column
    private String priority;

    @Column
    private String code;

    @Column
    private Integer storyPoints;

    @ManyToOne(fetch = FetchType.LAZY)
    @Getter(onMethod = @__( @JsonIgnore ))
    private Sprint sprint;

    @Override
    public int compareTo(Issue o) {
        return this.getCode().compareTo(o.getCode());
    }
}
