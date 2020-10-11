package com.koalmine.curriculumvitae.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
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
}
