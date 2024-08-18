package com.ridham.userProfile.exception;

public class RecordNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    public RecordNotFoundException(String messsage){
        super(messsage);
    }
}
