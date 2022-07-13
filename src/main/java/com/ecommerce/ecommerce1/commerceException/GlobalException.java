package com.ecommerce.ecommerce1.commerceException;

import com.ecommerce.ecommerce1.exception.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    private Logger logger = LoggerFactory.getLogger(GlobalException.class);

    @ExceptionHandler(value = CommerceException.class)
    public ResponseEntity<?> handleTradeAppException(CommerceException exception) {
        logger.error("TradeApp exception: {}", exception.getErrorMessage());
        return new ResponseEntity<>(ErrorResponse.builder().message(exception.getErrorMessage()).build(), exception.getStatus());
    }
    @ExceptionHandler(value = UserException.class)
    public ResponseEntity<?> userHandleException(UserException exception) {
        logger.error("TradeApp exception: {}", exception.getErrorMessage());
        return new ResponseEntity<>(ErrorResponse.builder().message(exception.getErrorMessage()).build(), exception.getStatus());
    }

   /* @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        logger.error("TradeApp exception: {}", exception.getMessage());
        return new ResponseEntity<>(ErrorResponse.builder().message(exception.getMessage()).build(), HttpStatus.BAD_REQUEST);
    }*/
}

