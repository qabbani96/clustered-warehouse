package com.warehouse.clustereddata.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DealAlreadyExistsException extends RuntimeException{

    public DealAlreadyExistsException(String message) {
        super(message);
    }
}
