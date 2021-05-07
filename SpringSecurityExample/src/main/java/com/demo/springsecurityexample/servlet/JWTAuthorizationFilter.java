package com.demo.springsecurityexample.servlet;

import com.demo.springsecurityexample.config.CustomUserService;
import com.demo.springsecurityexample.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class JWTAuthorizationFilter extends GenericFilter  {


    CustomUserService userService;

    public JWTAuthorizationFilter(CustomUserService userService) {
        this.userService = userService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String header = request.getHeader("Authorization");
        getBearerToken(header).ifPresent( token -> {
            userService.loadUserByJWTToken(token).ifPresent(
                    userDetails -> {
                       userDetails.getAuthorities().stream().forEach(authority -> System.out.println(">>>>>" + authority.getAuthority()));
                        SecurityContextHolder.getContext().setAuthentication(

                                new PreAuthenticatedAuthenticationToken(userDetails.getUsername(), "",
                                        userDetails.getAuthorities()));

                    }
            );
        });
        filterChain.doFilter(servletRequest,servletResponse);
    }

    private Optional<String> getBearerToken(String header){
        Optional<String> token = Optional.empty();
        if(header!=null && header.startsWith("Bearer")){
            token = Optional.of(header.replaceAll("Bearer", "").trim());
        }
        return token;
    }
}
