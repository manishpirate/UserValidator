package com.demo.springsecurityexample.web;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
//@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid request")
public class SecureAPI {

    Logger logger = Logger.getLogger("SecureAPI.class");

    @GetMapping("/secureAPI/data")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getSecureData(){
        logger.info("I am sending the response");
        return "This is secure Data";
    }
}
