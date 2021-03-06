package web.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "This email is already registered.")
public class ExistingEmailException extends RuntimeException {
    public ExistingEmailException() {
        super();
    }

    public ExistingEmailException(String message) {
        super(message);
    }

    public ExistingEmailException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExistingEmailException(Throwable cause) {
        super(cause);
    }
}