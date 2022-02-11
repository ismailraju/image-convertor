package com.raju.imageconvertor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
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
//    public ModelAndView handleError(HttpServletRequest req, Exception ex) {
////        logger.error("Request : " + req.getRequestURL() + " raised " + ex);
//        ex.printStackTrace();
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", ex);
//        mav.addObject("url", req.getRequestURL());
//        mav.setViewName("error");
//        return mav;
//    }
}
