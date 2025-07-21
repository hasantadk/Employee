package org.algorithmartisans.hasan.exception.model;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message){
        super(message);
    }
}
