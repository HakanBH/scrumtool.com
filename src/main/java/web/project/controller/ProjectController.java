package web.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.project.dto.ProjectDto;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @GetMapping("/create")
    public String createProject(Model model) {
        ProjectDto dto = new ProjectDto();
        model.addAttribute("projectDto", dto);

        return "createProject";
    }

    @PostMapping("/create")
    public String createProject(@ModelAttribute("projectDto") ProjectDto projectDto) {
        System.out.println(projectDto);
        return "main";
    }
}
