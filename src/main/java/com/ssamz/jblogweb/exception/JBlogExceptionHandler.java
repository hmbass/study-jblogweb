package com.ssamz.jblogweb.exception;

import com.ssamz.jblogweb.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class JBlogExceptionHandler {
    /*
    @ExceptionHandler(value = Exception.class)
    public String globalExceptionHandler(Exception e) {
        return "<h1>" + e.getMessage() + "</h1>";
    }
    */
    @ExceptionHandler(value = Exception.class)
    public ResponseDTO<String> globalExceptionHandler(Exception e) {
        return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }
}
