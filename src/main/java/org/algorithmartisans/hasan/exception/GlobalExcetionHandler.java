package org.algorithmartisans.hasan.exception;

import org.algorithmartisans.hasan.dto.response.ApiErrorResponse;
import org.algorithmartisans.hasan.exception.model.BusinessException;
import org.algorithmartisans.hasan.exception.model.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExcetionHandler {


    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<ApiErrorResponse> handleBusinessException(BusinessException e, WebRequest request) {
        ApiErrorResponse errorResponse = new ApiErrorResponse(LocalDateTime.now()
                , HttpStatus.BAD_REQUEST.value(),
                "business Rule violation",
                e.getMessage(),
                request.getDescription(false)
                );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleNotFoundException(NotFoundException e, WebRequest request) {
        ApiErrorResponse errorResponse = new ApiErrorResponse(LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                "değer bulunamadı",
                e.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class )
    public ResponseEntity<ApiErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        ApiErrorResponse errorResponse = new ApiErrorResponse(
                LocalDateTime.now(),HttpStatus.BAD_REQUEST.value(),
                "doğrulama hatası",
                "giriş doğrulaması hatalı",
                request.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleException(Exception e, WebRequest request) {
        ApiErrorResponse errorResponse = new ApiErrorResponse(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error",
                "An unexpected error occured",
                request.getDescription(false)
        );
    return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
