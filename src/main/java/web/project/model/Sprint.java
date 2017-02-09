package web.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "sprints")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sprint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @Column
    private Integer duration; //in days

    @Column
    private Integer number;

    @Column
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @Getter(onMethod = @__( @JsonIgnore ))
    private Project project;

    @OneToMany(mappedBy = "sprint", fetch = FetchType.LAZY)
    private Set<Issue> issues;
}
