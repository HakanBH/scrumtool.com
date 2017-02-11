package web.project.service;

import web.project.dto.IssueDto;

public interface IssueService {
    void save(IssueDto issueDto, Integer sprintId);

    void update(IssueDto issueDto, Integer issueId);
}
