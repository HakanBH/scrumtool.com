package web.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.project.dto.RegistrationDto;
import web.project.model.User;
import web.project.service.UserService;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/users/register")
    public String register(@Valid RegistrationDto registrationDto){
        userService.register(registrationDto);
        return "success";
    }
}
