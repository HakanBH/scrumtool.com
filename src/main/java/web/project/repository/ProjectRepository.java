package web.project.repository;

import org.springframework.data.repository.CrudRepository;
import web.project.model.Project;

public interface ProjectRepository extends CrudRepository<Project, Integer> {
}