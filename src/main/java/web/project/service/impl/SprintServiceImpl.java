package web.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.project.model.Sprint;
import web.project.repository.SprintRepository;
import web.project.service.SprintService;

@Service("sprintService")
public class SprintServiceImpl implements SprintService {

    @Autowired
    private SprintRepository sprintRepository;

    public Sprint createSprint(Sprint sprint){
        return null;
    }
}
