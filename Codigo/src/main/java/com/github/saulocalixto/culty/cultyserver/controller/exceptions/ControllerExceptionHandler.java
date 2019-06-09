package com.github.saulocalixto.culty.cultyserver.controller.exceptions;

import com.github.saulocalixto.culty.cultyserver.servico.exceptions.ObjetoNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ObjetoNaoEncontradoException.class)
    public ResponseEntity<ErroHTTP> objectNotFound (ObjetoNaoEncontradoException e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        ErroHTTP erro = new ErroHTTP(System.currentTimeMillis(), status.value(), "Não encontrado",
                e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(erro);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErroHTTP> IllegalArgumetException (IllegalArgumentException e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErroHTTP erro = new ErroHTTP(System.currentTimeMillis(), status.value(),
                "Requisição com campos em formato inválido", e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(erro);
    }
}
