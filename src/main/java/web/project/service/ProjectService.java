package web.project.service;

import web.project.dto.ProjectDto;
import web.project.model.Project;
import web.project.model.User;

import java.util.List;

public interface ProjectService {
    void createProject(ProjectDto projectDto);

    List<Project> userProjects(User user);

    Project findById(Integer id);

    boolean isMember(User user, Integer projectId);
}
