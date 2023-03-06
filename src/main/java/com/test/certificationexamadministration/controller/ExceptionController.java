package com.test.certificationexamadministration.controller;

import com.test.certificationexamadministration.exception.*;
import com.test.certificationexamadministration.model.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NotFoundException.class)
    ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(e.getCode(), e.getStatus(), e.getMessage()));
    }

    @ExceptionHandler(InvalidInputException.class)
    ResponseEntity<ErrorResponse> handleInvalidInputException(InvalidInputException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(e.getCode(), e.getStatus(), e.getMessage()));
    }

    @ExceptionHandler(ParentEntityDeletionException.class)
    ResponseEntity<ErrorResponse> handleParentEntityDeletionException(ParentEntityDeletionException e) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ErrorResponse(e.getCode(), e.getStatus(), e.getMessage()));
    }

    @ExceptionHandler(GeneralException.class)
    ResponseEntity<ErrorResponse> handleGeneralException(GeneralException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse(e.getCode(), e.getStatus(), e.getMessage()));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("E01", HttpStatus.BAD_REQUEST.name(), "Input date format may be incorrect. Use YYYY-MM-DD format"));
    }

    @ExceptionHandler(UnauthorizedException.class)
    ResponseEntity<ErrorResponse> handleUnauthorizedException(UnauthorizedException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse(e.getCode(), e.getStatus(), e.getMessage()));
    }

}
