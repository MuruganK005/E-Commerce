package com.ecommerce.ecommerce1.commerceException;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class CommerceException extends Exception{
    private HttpStatus status;
    private String errorMessage;
    public CommerceException(HttpStatus status, String errorMessage) {
        super(errorMessage);
        this.status = status;
        this.errorMessage = errorMessage;
    }
}
