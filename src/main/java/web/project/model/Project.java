package web.project.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Time dailyMeetings;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private Set<ProjectMember> members;
}
