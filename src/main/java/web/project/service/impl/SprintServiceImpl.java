package web.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.project.dto.SprintDto;
import web.project.model.Project;
import web.project.model.Sprint;
import web.project.repository.ProjectRepository;
import web.project.repository.SprintRepository;
import web.project.service.SprintService;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service("sprintService")
public class SprintServiceImpl implements SprintService {

    @Autowired
    private SprintRepository sprintRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public List<Sprint> findAll(Integer projectId) {
        return sprintRepository.findAllByProjectId(projectId);
    }

    public Sprint createSprint(SprintDto sprintDto, Integer projectId) {
        Project project = projectRepository.findOne(projectId);
        Integer numberOfSprint = findAll(projectId).size() + 1;
        long diff = sprintDto.getEndDate().getTime() - sprintDto.getStartDate().getTime();
        Integer days = Math.toIntExact(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
        Sprint sprint = new Sprint(null, sprintDto.getStartDate(), sprintDto.getEndDate(), days, numberOfSprint,
                "Inactive", project, null);
        return sprintRepository.save(sprint);
    }

    public Sprint findById(Integer sprintId){
        return sprintRepository.findOne(sprintId);
    }
}
