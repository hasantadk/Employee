package org.algorithmartisans.hasan.exception.model;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
