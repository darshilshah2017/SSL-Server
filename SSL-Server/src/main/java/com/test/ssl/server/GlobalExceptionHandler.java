package com.test.ssl.server;

import com.test.ssl.server.datamodel.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException exception){
        logger.error("BusinessException occurred with message: {}", exception.getLocalizedMessage());
        ErrorResponse response = new ErrorResponse("909",exception.getLocalizedMessage());
        return new ResponseEntity<ErrorResponse>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception exception){
        logger.error("Exception occurred with message: {} and stacktrace: {}", exception.getLocalizedMessage(), exception.getStackTrace());
        ErrorResponse response = new ErrorResponse("999",exception.getLocalizedMessage());
        return new ResponseEntity<ErrorResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
