package br.com.hotmart.apiteste.exceptions;

import br.com.hotmart.apiteste.dto.EntityNotFoundExceptionDTO;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Configuration
@RestControllerAdvice
public class GlobalHandlerException {
    @ResponseBody
    @ExceptionHandler(EntityNotFoundException.class)
    ResponseEntity<EntityNotFoundExceptionDTO> handleAutorizeException(EntityNotFoundException ex) {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(new EntityNotFoundExceptionDTO(ex.getMessage(),HttpStatus.NOT_FOUND.value()), headers, HttpStatus.NOT_FOUND);
    }
}
