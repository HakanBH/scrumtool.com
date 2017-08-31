package web.project.model.dto;

import lombok.*;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegistrationDto {

    @Email
    @NotNull
    @Size(min = 1, max = 50)
    private String email;

    @NotNull
    @Size(min = 1, max = 50)
    private String firstName;

    @NotNull
    @Size(min = 1, max = 50)
    private String lastName;

    @NotNull
    @Size(min = 1, max = 50)
    private String password;

    @NotNull
    @Size(min = 1, max = 50)
    private String passwordConfirm;
}
