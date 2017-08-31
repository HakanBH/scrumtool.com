package web.project.service;

import web.project.model.dto.ProjectDto;
import web.project.model.Project;
import web.project.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ProjectService {
    Integer getNumberOfIssues(Project project);

    Project create(ProjectDto projectDto, HttpServletRequest request);

    List<Project> userProjects(User user);

    Project findById(Integer id);

    boolean isMember(User user, Integer projectId);
}
