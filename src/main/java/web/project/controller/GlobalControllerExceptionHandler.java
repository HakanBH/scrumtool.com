package web.project.controller;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import web.project.exception.UnauthorizedException;

import java.sql.SQLException;


@ControllerAdvice
public class GlobalControllerExceptionHandler {
    public static final String UNEXISTING_RESOURCE_MESSAGE = "Sorry, this page isn't available. \n" +
            "The link you followed may be broken, or the page may have been removed.";

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Exception.class, SQLException.class})
    public String defaultErrorHandler(Model model, Exception e) throws Exception {
//        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null)
//            throw e;
        e.printStackTrace();
        model.addAttribute("errorMessage", "Something went wrong. Please try again later.");
        return "error";
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public String unauthorizedException(Model model, Exception e) {
        e.printStackTrace();
        model.addAttribute("errorMessage", "You're not authorized to see this content.");
        return "error";
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public String badRequest(Model model, Exception e) {
        e.printStackTrace();
        model.addAttribute("errorMessage", UNEXISTING_RESOURCE_MESSAGE);
        return "error";
    }
}
