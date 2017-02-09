package web.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Wrong email or password.")
public class WrongEmailOrPasswordException extends Exception {
    public WrongEmailOrPasswordException() {
        super();
    }

    public WrongEmailOrPasswordException(String message) {
        super(message);
    }

    public WrongEmailOrPasswordException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongEmailOrPasswordException(Throwable cause) {
        super(cause);
    }
}
