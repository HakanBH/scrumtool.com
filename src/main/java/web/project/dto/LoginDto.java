package web.project.dto;

import lombok.*;
import org.hibernate.validator.constraints.Email;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {

    @Email
    @NotNull
    @Size(min = 1, max = 50)
    private String email;

    @NotNull
    @Size(min = 1, max = 50)
    private String password;
}