package com.ridham.userProfile.exception;

import com.ridham.userProfile.entities.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import java.util.Date;
@ControllerAdvice()
public class CustomeExceptionHandler{

    private String NO_RECORD_FOUND = "Record not found";
    private String BAD_REQUEST = "Bad request";



    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> validationFailureExceptionHandler(MethodArgumentNotValidException ex, WebRequest request){
        ErrorMessage errorMessage = new ErrorMessage(
                HttpStatus.BAD_REQUEST.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

}
