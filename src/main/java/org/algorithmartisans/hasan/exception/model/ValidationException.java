package org.algorithmartisans.hasan.exception.model;

import lombok.Getter;

import java.util.Map;

@Getter
public class ValidationException extends RuntimeException {
    private final Map<String, String> ValidationErrors;
    public ValidationException(String message,Map<String, String> validationErrors) {
        super(message);
        this.ValidationErrors = validationErrors;
    }
}
