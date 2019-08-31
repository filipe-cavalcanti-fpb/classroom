package com.sogo.classroom.service.handler;

import com.sogo.classroom.persistence.DTO.response.MensagemRetornoDTO;
import com.sogo.classroom.service.exceptions.BusinessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandlerBusinessException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {BusinessException.class})
    protected ResponseEntity<Object> handleBusinessException(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, new MensagemRetornoDTO(ex.getMessage()),
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
        return handleExceptionInternal(ex, new MensagemRetornoDTO(ex.getMessage()), headers, HttpStatus.BAD_REQUEST, request);
    }
}
