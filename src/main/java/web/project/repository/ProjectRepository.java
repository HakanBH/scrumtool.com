package web.project.repository;

import org.springframework.data.repository.CrudRepository;
import web.project.model.Project;

/**
 * Created by User on 28.1.2017 г..
 */

public interface ProjectRepository extends CrudRepository<Project, Integer> {
}