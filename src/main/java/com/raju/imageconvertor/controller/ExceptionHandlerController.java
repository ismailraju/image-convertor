package com.raju.imageconvertor.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

//@ControllerAdvice
public class ExceptionHandlerController {

//    @ControllerAdvice
//    class GlobalControllerExceptionHandler {
//        @ResponseStatus(HttpStatus.CONFLICT)  // 409
//        @ExceptionHandler(DataIntegrityViolationException.class)
//        public void handleConflict() {
//            // Nothing to do
//        }
//    }


    // Total control - setup a model and return the view name yourself. Or
    // consider subclassing ExceptionHandlerExceptionResolver (see below).
//    @ExceptionHandler(Exception.class)
//    public ModelAndView handleError(HttpServletRequest req, Exception ex, Model model) {
////        logger.error("Request : " + req.getRequestURL() + " raised " + ex);
//        ex.printStackTrace();
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("message", ex);
////        mav.addObject("exception", ex);
////        mav.addObject("url", req.getRequestURL());
////        mav.setViewName("error");
//        mav.setViewName("index");
//        return mav;
//    }


//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
//    public Map<String, String> handleValidationExceptions(
//            MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        return errors;
//    }
}
