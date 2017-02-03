package web.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import web.project.dto.ProjectDto;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "projects")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "project_id")
    private Integer id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String dailyMeetings;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<ProjectMember> members;

    public Project(ProjectDto projectDto) {
        this.name = projectDto.getName();
        this.description = projectDto.getDescription();
        this.dailyMeetings = projectDto.getDailyMeetings();
        this.startDate = projectDto.getStartDate();
        this.endDate = projectDto.getEndDate();
    }
}
