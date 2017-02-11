package web.project.model;

import lombok.*;
import org.hibernate.validator.constraints.Email;
import web.project.dto.RegistrationDto;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true, nullable = false)
    @Email
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<ProjectMember> projects;

    public User(RegistrationDto registrationDto) {
        this.email = registrationDto.getEmail();
        this.firstName = registrationDto.getFirstName();
        this.lastName = registrationDto.getLastName();
        this.password = registrationDto.getPassword();
    }
}
