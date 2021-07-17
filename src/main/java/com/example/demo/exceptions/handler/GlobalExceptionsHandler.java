package com.example.demo.exceptions.handler;


import com.example.demo.response.JsonResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.impl.SizeLimitExceededException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

/**
 * @author Okala III
 * Date Created: 4/15/2021
 * Project Name: SIRS_BACKEND
 */

@Slf4j
@ControllerAdvice
class GlobalExceptionsHandler
        extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value = {IllegalArgumentException.class, NoSuchElementException.class})
    protected ResponseEntity<?> handleConflict(Exception ex, WebRequest request) throws Exception {

        //add headers to be returned with response
        HttpHeaders headers = new HttpHeaders();


        if (ex instanceof IllegalArgumentException) {
            log.error(ex.getMessage(), ex);
            return new ResponseEntity<>(new JsonResponse(ex.getMessage()), HttpStatus.BAD_REQUEST);

        }else if (ex instanceof NoSuchElementException) {
            log.error(ex.getMessage(), ex);
            return new ResponseEntity<>(new JsonResponse(ex.getMessage()), HttpStatus.NOT_FOUND);

        } else {
            // rethrow the given exception for further processing through the HandlerExceptionResolver chain.
            throw ex;
        }
    }


}
