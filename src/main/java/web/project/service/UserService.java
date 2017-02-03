package web.project.service;

import web.project.dto.LoginDto;
import web.project.dto.RegistrationDto;
import web.project.exception.ExistingEmailException;
import web.project.exception.WrongEmailOrPasswordException;
import web.project.model.User;

public interface UserService {

    User register(RegistrationDto registrationDto) throws ExistingEmailException;

    User login(LoginDto loginDto) throws WrongEmailOrPasswordException;
}
