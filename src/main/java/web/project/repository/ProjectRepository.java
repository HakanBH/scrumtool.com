package web.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import web.project.model.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Integer> {
}