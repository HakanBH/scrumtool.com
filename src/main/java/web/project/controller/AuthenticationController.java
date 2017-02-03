package web.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.project.dto.LoginDto;
import web.project.dto.RegistrationDto;
import web.project.model.User;
import web.project.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public String register(@Valid RegistrationDto registrationDto, HttpServletRequest request) {
        User user = userService.register(registrationDto);
        request.getSession().setAttribute("loggedUser", user);
        return "redirect:/main";
    }

    @PostMapping(value = "/login")
    public String register(@Valid LoginDto loginDto, HttpServletRequest request) {
        User user = userService.login(loginDto);
        request.getSession().setAttribute("loggedUser", user);
        return "redirect:/main";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/index";
    }

}
