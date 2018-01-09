package com.assessment.upload_file_api.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;

@ControllerAdvice
public class FileUploadControllerAdvice {

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(final StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MultipartException.class)
    public ResponseEntity<Object> handleMaxUploadSizeException(MultipartException e) {
        return ResponseEntity.badRequest().body(e.getCause().getMessage());
    }
}
