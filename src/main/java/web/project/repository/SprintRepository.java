package web.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import web.project.model.Sprint;

@Repository
public interface SprintRepository extends CrudRepository<Sprint, Integer> {
}
