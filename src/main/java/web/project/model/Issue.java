package web.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import web.project.model.enums.IssueStatus;
import web.project.model.enums.IssueType;

import javax.persistence.*;

@Entity
@Table(name = "issues")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Issue {
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

    @ManyToOne(fetch = FetchType.LAZY)
    @Getter(onMethod = @__( @JsonIgnore ))
    private Sprint sprint;
}
