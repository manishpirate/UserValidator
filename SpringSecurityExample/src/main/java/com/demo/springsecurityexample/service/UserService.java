package com.demo.springsecurityexample.service;

import com.demo.springsecurityexample.DTO.LoginDTO;
import com.demo.springsecurityexample.config.JWTProvider;
import com.demo.springsecurityexample.entity.User;
import com.demo.springsecurityexample.entity.UserRoles;
import com.demo.springsecurityexample.repository.RoleRepository;
import com.demo.springsecurityexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    JWTProvider jwtProvider;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    AuthenticationManager authenticationManager;

    public Optional<String> getSignInDetails(LoginDTO loginDTO) throws UsernameNotFoundException{
        Optional<String> token = Optional.empty();
        //first we will fetch the details of the user
        Optional<User> user = userRepository.findUserByUserName(loginDTO.getUsername());
        if(user.isPresent()){
           User userObj = user.get();
           authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userObj.getUserName(), loginDTO.getPassword()));
           //fetching the list of the roles for user
            Set<UserRoles> userRoles = roleRepository.getUserRolesByUserId(userObj.getId());
           String tokenvalue = jwtProvider.createToken(userObj,userRoles);
           token = Optional.of(tokenvalue);
        }else {
            throw new UsernameNotFoundException("Unable to find user details");
        }
        return token;
    }


}
