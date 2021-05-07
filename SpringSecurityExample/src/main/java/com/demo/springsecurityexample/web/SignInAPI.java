package com.demo.springsecurityexample.web;

import com.demo.springsecurityexample.DTO.LoginDTO;
import com.demo.springsecurityexample.config.JWTProvider;
import com.demo.springsecurityexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.logging.Logger;

@RestController
public class SignInAPI {
    private static Logger logger = Logger.getLogger("SignInAPI.class");

    @Autowired
    UserService userService;

    //This method was returning a simple authentication obj. we are modifying same to return a JWT
   /* @PostMapping("/signin")
    public Authentication getUserSignIn(@RequestBody LoginDTO loginDTO){
        logger.info("I have reached this point");
        return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword()));
    }*/

    @PostMapping("/signin")
    public String getUserSignIn(@RequestBody LoginDTO loginDTO) {
        logger.info("Starting to build a JWT Token");
        Optional<String> returnVal = userService.getSignInDetails(loginDTO);
        if(returnVal.isPresent()){
            return returnVal.get();
        }else{
            return "No JWT String will be given";
        }
    }

}
