package web.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import web.project.dto.RegistrationDto;
import web.project.model.Project;
import web.project.model.ProjectMember;
import web.project.model.User;
import web.project.repository.ProjectRepository;
import web.project.repository.UserRepository;

import javax.transaction.Transactional;
import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;

@SpringBootApplication
public class ScrumtoolApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(ScrumtoolApplication.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProjectRepository projectRepository;

    public static void main(String[] args) {
        SpringApplication.run(ScrumtoolApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... strings) throws Exception {
//        // save a couple of books
//        User hakan = new User(new RegistrationDto("hakan@gmail.com", "Hakan", "Hyusein", "pass", "pass"));
//        User deniz = new User(new RegistrationDto("deniz@gmail.com", "Deniz", "Hyuseinov", "pass", "pass"));
//
//        Project project = new Project(null, "Ticketmaster", "This is description", new Time(8, 30, 0), new Date(2016, 5, 5), new Date(2016, 5, 5), null);
//
//        ProjectMember member1 = new ProjectMember("Scrum Master", project, hakan);
//        ProjectMember member2 = new ProjectMember("Developer", project, deniz);
//
//        project.setMembers(new HashSet<ProjectMember>(){{
//            add(member1);
//            add(member2);
//        }});
//        userRepository.save(hakan);
//        projectRepository.save(project);
    }
}
