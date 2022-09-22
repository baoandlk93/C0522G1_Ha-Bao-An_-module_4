package com.example.logging;

import com.example.exception.EmptyBooksException;
import com.example.exception.OutOfBoundsLimitException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(EmptyBooksException.class)
    public String showErrorEmpty(){
        return "errorPage";
    }
    @ExceptionHandler(OutOfBoundsLimitException.class)
    public String showErrorFull(){
        return "errorPage";
    }
}
