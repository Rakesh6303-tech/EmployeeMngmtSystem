package net.javaguides.ems.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    // if emplopyee id is given then id is not present in DB it will Throw this Exception RNFE
    // SpringBoot will catch the exception along HttpStatus and send to the Client.
    // Create Parameterized Constructor
    public ResourceNotFoundException(String message){
        super(message);
    }
}
