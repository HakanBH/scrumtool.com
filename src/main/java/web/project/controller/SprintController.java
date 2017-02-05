package web.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.project.model.Sprint;
import web.project.service.SprintService;

@Controller
@RequestMapping("sprints")
public class SprintController {
    @Autowired
    private SprintService sprintService;

    @GetMapping("/create")
    public String get(Sprint sprint) {
        return "createSprint";
    }
}
