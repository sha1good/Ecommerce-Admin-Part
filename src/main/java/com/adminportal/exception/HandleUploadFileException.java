package com.adminportal.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@ControllerAdvice
public class HandleUploadFileException {

    //@Value is used to read propertises from application.propertise file
    @Value("$spring.http.multipart.max-file-size")
    private String maxFileSize;

    @ExceptionHandler({MaxUploadSizeExceededException.class,BookUploadException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String  handleUploadFileError(RedirectAttributes ra){
        System.out.println("Error Uplaoding the file  from HandleUploadFileException.....");
        ra.addFlashAttribute("error", "You will not be able to add file bigger than " + maxFileSize  +  "Size");
        return "addBook";
    }
}
