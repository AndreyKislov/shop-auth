package ua.kislov.reg_and_auth_service.handlers;

import org.hibernate.HibernateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ua.kislov.reg_and_auth_service.exception.UserNotFoundException;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler
    public ResponseEntity<String> userNotFound(UserNotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.valueOf(404));
    }

    @ExceptionHandler
    public ResponseEntity<String> dbOrJpaException(HibernateException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
