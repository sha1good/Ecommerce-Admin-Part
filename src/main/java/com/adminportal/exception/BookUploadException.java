package com.adminportal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BookUploadException extends RuntimeException {
    public BookUploadException(String message) {
        super(message);
    }
}
