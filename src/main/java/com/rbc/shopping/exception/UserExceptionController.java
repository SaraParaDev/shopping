package com.rbc.shopping.exception;

import com.rbc.shopping.util.AppConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Class for handling application runtime exceptions.
 *
 * @author SARA
 */
@RestControllerAdvice
public class UserExceptionController {

    /**
     * @param exception Object representing UserNotFoundException.
     * @return Response Entity for User Not found.
     */
    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<Object> userNotFound(UserNotFoundException exception) {
        return new ResponseEntity<>(AppConstants.USER_NOT_FOUND, HttpStatus.NOT_FOUND);
    }

    /**
     * @param exception Object representing ForbiddenException.
     * @return Response Entity for Unauthorized access.
     */
    @ExceptionHandler(value = ForbiddenException.class)
    public ResponseEntity<Object> forbiddenException(ForbiddenException exception) {
        return new ResponseEntity<>(AppConstants.UNAUTHORIZED, HttpStatus.FORBIDDEN);
    }

    /**
     * @param exception Object representing ApplicationException.
     * @return Response Entity for Application Exception.
     */
    @ExceptionHandler(value = ApplicationException.class)
    public ResponseEntity<Object> applicationException(ApplicationException exception) {
        return new ResponseEntity<>(AppConstants.APP_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
