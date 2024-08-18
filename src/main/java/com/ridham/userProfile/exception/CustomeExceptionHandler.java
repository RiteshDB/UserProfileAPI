package com.ridham.userProfile.exception;

import com.ridham.userProfile.entities.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import java.util.Date;
@ControllerAdvice()
public class CustomeExceptionHandler{

    private String NO_RECORD_FOUND = "Record not found";
    private String BAD_REQUEST = "Bad request";

    @ExceptionHandler(value = RecordNotFoundException.class)
    public ResponseEntity<ErrorMessage>  recordNotFoundExceptionHandler(RecordNotFoundException ex, WebRequest req){
        ErrorMessage message = new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                ex.getMessage(),
                req.getDescription(false));
        return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
    }

}
