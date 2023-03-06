package cinema.controller.advice;

import cinema.exception.TicketAlreadyPurchasedException;
import cinema.exception.TicketOutOfBoundsException;
import cinema.exception.WrongPasswordException;
import cinema.exception.WrongTokenException;
import cinema.model.response.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorControllerAdvice {
    @ExceptionHandler({TicketAlreadyPurchasedException.class,
                        TicketOutOfBoundsException.class,
                        WrongTokenException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDTO badRequestError(Exception ex) {
        return new ErrorDTO(ex.getMessage());
    }

    @ExceptionHandler(WrongPasswordException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorDTO wrongPasswordError(Exception ex) {
        return new ErrorDTO(ex.getMessage());
    }
}
