package web.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.project.exception.UnauthorizedException;
import web.project.model.Project;
import web.project.model.Sprint;
import web.project.model.User;
import web.project.model.dto.ProjectDto;
import web.project.model.dto.SprintDto;
import web.project.service.ProjectService;
import web.project.service.SprintService;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private SprintService sprintService;

    @GetMapping("/create")
    public String get(ProjectDto projectDto) {
        return "createProject";
    }

    @PostMapping("/create")
    public String createProject(@ModelAttribute("projectDto") ProjectDto projectDto, HttpServletRequest request) {
        Project project = projectService.create(projectDto, request);
        return "redirect:/projects/" + project.getId();
    }

    @GetMapping({"/{projectId}", "/{projectId}/backlog"})
    public String backlogView(@PathVariable("projectId") Integer projectId, Model model, HttpServletRequest request) throws UnauthorizedException {
        if (!projectService.isMember((User) request.getSession().getAttribute("loggedUser"), projectId)) {
            throw new UnauthorizedException();
        }

        Project project = projectService.findById(projectId);
        List<Sprint> sprints = project.getSprints();
        Collections.sort(sprints, (o1, o2) -> {
            return o2.getNumber() - o1.getNumber();
        });

        model.addAttribute("project", project);
        model.addAttribute("sprints", sprints);

        return "projectBacklog";
    }

    @GetMapping("/{projectId}/board")
    public String boardView(@PathVariable("projectId") Integer projectId, Model model, HttpServletRequest request)
            throws
            UnauthorizedException {
        if (!projectService.isMember((User) request.getSession().getAttribute("loggedUser"), projectId)) {
            throw new UnauthorizedException();
        }
        model.addAttribute(projectService.findById(projectId));
        return "projectBoard";
    }

    @GetMapping
    @ResponseBody
    public List<Project> getProjects(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("loggedUser");
        return projectService.userProjects(user);
    }

    @GetMapping(value = "/{projectId}/sprints", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<Sprint> getAll(@PathVariable("projectId") Integer projectId, HttpServletRequest request) throws UnauthorizedException {
        if (!projectService.isMember((User) request.getSession().getAttribute("loggedUser"), projectId)) {
            throw new UnauthorizedException();
        }
        List<Sprint> sprints = sprintService.findAll(projectId);
        for (Sprint sprint : sprints) {
            Collections.sort(sprint.getIssues());
        }
        return sprints;
    }


    @GetMapping("{projectId}/sprints/create")
    public String createSprintView() {
        return "createSprint";
    }

    @PostMapping("{projectId}/sprints/create")
    @ResponseBody
    public Sprint createSprint(@PathVariable("projectId") Integer projectId, @RequestBody SprintDto sprintDto, HttpServletRequest request) throws UnauthorizedException {
        if (!projectService.isMember((User) request.getSession().getAttribute("loggedUser"), projectId)) {
            throw new UnauthorizedException();
        }
        return sprintService.createSprint(sprintDto, projectId);
    }

    @GetMapping("{projectId}/sprints/{sprintId}")
    public String sprintView(Model model, @PathVariable("sprintId") Integer sprintId, @PathVariable("projectId")
            Integer projectId) {
        model.addAttribute("sprint", sprintService.findById(sprintId));
        model.addAttribute("project", projectService.findById(projectId));
        return "sprintBacklog";
    }
}
