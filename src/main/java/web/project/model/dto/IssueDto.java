package web.project.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import web.project.model.Issue;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IssueDto {
    private String summary;
    private String description;
    private String type;
    private String priority;
    private String status;
    private Integer storyPoints;

    public Issue toEntity(){
        Issue issue = new Issue();
        issue.setDescription(this.description);
        issue.setPriority(this.priority);
        issue.setSummary(this.summary);
        issue.setType(this.type);
        issue.setStoryPoints(this.storyPoints);
        issue.setStatus(this.status);
        return issue;
    }
}
