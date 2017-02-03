package web.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import web.project.dto.ProjectDto;
import web.project.model.Project;
import web.project.model.User;
import web.project.service.ProjectService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/create")
    public String get(ProjectDto projectDto) {
        return "createProject";
    }

    @PostMapping("/create")
    public String createProject(@ModelAttribute("projectDto") ProjectDto projectDto) {
        projectService.createProject(projectDto);
        return "main";
    }

    @GetMapping
    @ResponseBody
    public List<Project> dailyMeetings(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("loggedUser");
        return projectService.userProjects(user);
    }
}
