package web.project.service.impl;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import web.project.dto.LoginDto;
import web.project.dto.RegistrationDto;
import web.project.exception.ExistingEmailException;
import web.project.exception.WrongEmailOrPasswordException;
import web.project.model.User;
import web.project.repository.UserRepository;
import web.project.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void register(RegistrationDto dto) throws ExistingEmailException {
        try {
            userRepository.save(new User(dto));
        } catch (DataAccessException e) {
            if (e.getCause() instanceof ConstraintViolationException) {
                throw new ExistingEmailException();
            }
        }
    }

    @Override
    public User login(LoginDto dto) throws WrongEmailOrPasswordException {
        User user = userRepository.findByEmailAndPassword(dto.getEmail(), dto.getPassword());
        if (user != null) {
            return user;
        } else {
            throw new WrongEmailOrPasswordException();
        }
    }
}
