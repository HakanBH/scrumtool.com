package web.project.model;

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
    private String name;

    @Column
    private String description;

    @Column
    private IssueStatus status;

    @Column
    private IssueType type;

    @ManyToOne(fetch = FetchType.LAZY)
    private Sprint sprint;
}
