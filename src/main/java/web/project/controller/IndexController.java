package web.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import web.project.dto.LoginDto;
import web.project.dto.RegistrationDto;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(LoginDto loginDto, RegistrationDto registrationDto, HttpServletRequest request) {
        if(request.getSession().getAttribute("loggedUser") != null){
            return "main";
        }
        return "index";
    }
}
