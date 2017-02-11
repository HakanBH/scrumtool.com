package web.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import web.project.model.Issue;

@Repository
public interface IssueRepository extends CrudRepository<Issue, Integer>{
}
