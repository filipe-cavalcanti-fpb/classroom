package com.sogo.classroom.service.exceptions;

public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = -2046628856317590099L;

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(String message) {
        super(message);
    }
}
