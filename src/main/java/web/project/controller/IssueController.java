package web.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.project.model.dto.IssueDto;
import web.project.service.IssueService;

@RestController
@RequestMapping("/issues")
public class IssueController {

    @Autowired
    private IssueService issueService;

    @PostMapping("/{sprintId}")
    public void create(@RequestBody IssueDto issueDto, @PathVariable("sprintId") Integer sprintId) {
        issueService.save(issueDto, sprintId);
    }

    @PutMapping("/{issueId}")
    public void update(@RequestBody IssueDto issueDto, @PathVariable("issueId") Integer issueId){
        issueService.update(issueDto, issueId);
    }
}
