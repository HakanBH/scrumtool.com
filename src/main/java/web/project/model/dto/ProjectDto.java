package web.project.model.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {

    @NotNull
    @Length(min = 1, max = 30)
    private String name;

    @Length(max = 1000)
    private String description;

    @Length(max = 8)
    private String code;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    private String dailyMeetings;

    private List<ProjectMember> projectMembers = new ArrayList<>(Arrays.asList(new ProjectMember("User", "Role")));

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public class ProjectMember {
        private String user;
        private String role;
    }
}
