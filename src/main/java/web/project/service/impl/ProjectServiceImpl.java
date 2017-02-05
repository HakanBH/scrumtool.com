package web.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.project.dto.ProjectDto;
import web.project.model.Project;
import web.project.model.ProjectMember;
import web.project.model.User;
import web.project.repository.ProjectMemberRepository;
import web.project.repository.ProjectRepository;
import web.project.repository.UserRepository;
import web.project.service.ProjectService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProjectMemberRepository projectMemberRepository;

    @Override
    public void createProject(ProjectDto projectDto) {
        Project project = new Project(projectDto);
        String emails = projectDto.getProjectMembers().get(0).getUser();
        String roles = projectDto.getProjectMembers().get(0).getRole();

        String[] userEmails = emails.split(",");
        String[] userRoles = roles.split(",");

        Set<ProjectMember> projectMembers = new HashSet<>();
        for (int i = 0; i < userEmails.length - 1; i++) {
            User user = userRepository.findByEmail(userEmails[i]);
            ProjectMember pm = new ProjectMember(null, userRoles[i], project, user);
            user.getProjects().add(pm);
            projectMembers.add(pm);
        }
        project.setMembers(projectMembers);
        projectRepository.save(project);

        for (ProjectMember pm : projectMembers) {
            projectMemberRepository.save(pm);
        }
    }

    public List<Project> userProjects(User user) {
        List<ProjectMember> projectMembers = projectMemberRepository.findByUserId(user.getId());
        List<Project> projects = new ArrayList<>();
        for(ProjectMember projectMember : projectMembers){
            projects.add(projectMember.getProject());
        }
        return projects;
    }

    public Project findById(Integer id){
        return projectRepository.findOne(id);
    }
}
