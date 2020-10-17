package com.koalmine.curriculumvitae.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(FooterTypeException.class)
    public ResponseEntity<FooterTypeExceptionModel> footerPageNameException(FooterTypeException e){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMMM-yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        FooterTypeExceptionModel model = new FooterTypeExceptionModel(
                e.getPageName(), "The Page Does Not Exist", dtf.format(now)
        );
        return new ResponseEntity<>(model, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UsernameAlreadyExistsException.class)
    public ResponseEntity<CommonException> usernameAlreadyExistsException(UsernameAlreadyExistsException e){

        CommonException exception = new CommonException(
                "Error",
                e.getMessage(),
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserValidationException.class)
    public ResponseEntity<CommonException> createUserValidationException(UserValidationException e){

        CommonException exception = new CommonException(
                "Error",
                e.getMessage(),
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public CommonException javaxValidationHandling(MethodArgumentNotValidException e){

        return new CommonException(
                "Error",
                e.getBindingResult().getFieldError().getDefaultMessage(),
                ZonedDateTime.now(ZoneId.of("Z"))
        );
    }
}
