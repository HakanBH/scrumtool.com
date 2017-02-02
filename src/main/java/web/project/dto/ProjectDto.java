package web.project.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by User on 1.2.2017 г..
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
    private String name;

    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    private String dailyMeetings;

    private List<ProjectMember> projectMemberList = new ArrayList<>(Arrays.asList(new ProjectMember("User","Role")));

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    private static class ProjectMember {
        private String user;
        private String role;
    }
}
