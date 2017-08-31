package web.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.project.model.dto.IssueDto;
import web.project.model.Issue;
import web.project.model.Project;
import web.project.model.Sprint;
import web.project.repository.IssueRepository;
import web.project.repository.SprintRepository;
import web.project.service.IssueService;
import web.project.service.ProjectService;

@Service("issueService")
public class IssueServiceImpl implements IssueService {
    @Autowired
    private SprintRepository sprintRepository;

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private ProjectService projectService;

    @Override
    public void save(IssueDto issueDto, Integer sprintId) {
        Sprint sprint = sprintRepository.findOne(sprintId);
        Project project = sprint.getProject();
        Issue issue = issueDto.toEntity();
        issue.setSprint(sprint);
        Integer count = projectService.getNumberOfIssues(project);
        issue.setCode(project.getCode() + "-" + count);
        issue.setStatus("To Do");

        issueRepository.save(issue);
    }

    @Override
    public void update(IssueDto issueDto, Integer issueId) {
        Issue issue = issueRepository.findOne(issueId);
        Issue updated = setNotNullFields(issue, issueDto);
        issueRepository.save(updated);
    }

    public Issue setNotNullFields(Issue issue, IssueDto issueDto) {
        if (issueDto.getDescription() != null) {
            issue.setDescription(issueDto.getDescription());
        }
        if (issueDto.getPriority() != null) {
            issue.setPriority(issueDto.getPriority());
        }
        if (issueDto.getStatus() != null) {
            issue.setStatus(issueDto.getStatus());
        }
        if (issueDto.getStoryPoints() != null) {
            issue.setStoryPoints(issueDto.getStoryPoints());
        }
        if (issueDto.getSummary() != null) {
            issue.setSummary(issueDto.getSummary());
        }
        if (issueDto.getType() != null) {
            issue.setType(issueDto.getType());
        }
        return issue;
    }
}
