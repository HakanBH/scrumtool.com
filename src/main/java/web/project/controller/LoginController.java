package web.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import web.project.dto.LoginDto;
import web.project.model.User;
import web.project.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/users/login")
    public String register(@Valid LoginDto loginDto, HttpServletRequest request) {
        User user = userService.login(loginDto);
        request.getSession().setAttribute("loggedUser", user);
        return "redirect:/main";
    }
}
