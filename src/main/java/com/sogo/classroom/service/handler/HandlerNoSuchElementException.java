package com.sogo.classroom.service.handler;

import com.sogo.classroom.persistence.DTO.response.MensagemRetornoDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class HandlerNoSuchElementException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {NoSuchElementException.class})
    protected ResponseEntity<Object> handleNoSuchElementException(RuntimeException ex, WebRequest request){
        return handleExceptionInternal(ex, new MensagemRetornoDTO("Nemhum registro encontrado"),
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
