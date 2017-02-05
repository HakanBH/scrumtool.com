package web.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import web.project.model.ProjectMember;

import java.util.List;

@Repository
public interface ProjectMemberRepository extends CrudRepository<ProjectMember, Integer>{
    List<ProjectMember> findByUserId(Integer userId);
}
