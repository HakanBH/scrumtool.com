package web.project.service.impl;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import web.project.model.dto.LoginDto;
import web.project.model.dto.RegistrationDto;
import web.project.exception.ExistingEmailException;
import web.project.exception.WrongEmailOrPasswordException;
import web.project.model.User;
import web.project.repository.UserRepository;
import web.project.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public User register(RegistrationDto dto) throws ExistingEmailException {
        try {
            User user = new User(dto);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        } catch (DataAccessException e) {
            if (e.getCause() instanceof ConstraintViolationException) {
                throw new ExistingEmailException();
            }
        }
        return null;
    }

    @Override
    public User login(LoginDto dto) throws WrongEmailOrPasswordException {
        User user = userRepository.findByEmail(dto.getEmail());
        if (user != null && passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            return user;
        } else {
            throw new WrongEmailOrPasswordException();
        }
    }
}
