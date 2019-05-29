package com.github.saulocalixto.culty.cultyserver.controller.exceptions;

import com.github.saulocalixto.culty.cultyserver.servico.exceptions.ObjetoNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjetoNaoEncontradoException.class)
    public ResponseEntity<StandardError> objectNotFound (ObjetoNaoEncontradoException e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado",
                e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(error);
    }
}
