package org.hubson404.pracadomowa5.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(DataProcessingException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    ErrorInformation dataProcessingHandler(DataProcessingException exc) {
        return new ErrorInformation(exc.getMessage());
    }

    @ExceptionHandler(InsufficientDataException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorInformation insufficientDataHandler(InsufficientDataException exc) {
        return new ErrorInformation(exc.getMessage());
    }
}
