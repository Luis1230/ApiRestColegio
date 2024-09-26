package com.colegio.rest.apirestcolegio.exception;

import com.colegio.rest.apirestcolegio.dto.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Arrays;

@RestControllerAdvice
public class GlobalErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<BaseResponse<CustomErrorResponse>> handleModelNotFoundException(ModelNotFoundException ex, WebRequest req) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(LocalDateTime.now(), ex.getMessage(), req.getDescription(false));

        return new ResponseEntity<>(new BaseResponse<CustomErrorResponse>("400",
                "Ocurrio un error.",
                "Ocurrio un error.",
                errorResponse,
                null), HttpStatus.NOT_FOUND);
    }

}