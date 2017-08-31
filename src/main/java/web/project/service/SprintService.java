package web.project.service;

import web.project.model.dto.SprintDto;
import web.project.model.Sprint;

import java.util.List;

public interface SprintService {
    Sprint findById(Integer sprintId);

    List<Sprint> findAll(Integer projectId);

    Sprint createSprint(SprintDto sprintDto, Integer projectId);
}
