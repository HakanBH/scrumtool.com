package web.project.service;

import web.project.model.dto.IssueDto;

public interface IssueService {
    void save(IssueDto issueDto, Integer sprintId);

    void update(IssueDto issueDto, Integer issueId);
}
