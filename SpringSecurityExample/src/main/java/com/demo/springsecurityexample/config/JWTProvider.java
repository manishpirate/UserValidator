package com.demo.springsecurityexample.config;

import com.demo.springsecurityexample.entity.User;
import com.demo.springsecurityexample.entity.UserRoles;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class JWTProvider {

    private final String ROLES_KEY = "roles";

    private String secretKey;
    private long tokenDuration;

    private JwtParser JWTparser;

    @Autowired
    public JWTProvider(@Value("${security.jwt.token.secret-key}") String secretKey,
                       @Value("${security.jwt.token.expiration}") long tokenDuration) {
        this.secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
        this.tokenDuration = tokenDuration;
    }

    public String createToken(User user, Set<UserRoles> roles){
        //Setting the subject in the token claims first
        Claims claims = Jwts.claims().setSubject(user.getUserName());
        //adding roles to this
        claims.put(ROLES_KEY, roles.stream().map (role -> new SimpleGrantedAuthority(role.getAuthority()))
                .filter(Objects::nonNull)
                .peek(role -> System.out.println("####" + role.getAuthority()))
                .collect(Collectors.toList()));
        //creating the token now
        Date now = new Date();
        Date expirationTime = new Date(now.getTime() +  this.tokenDuration);
        return Jwts.builder().setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expirationTime)
                .signWith(SignatureAlgorithm.HS256, this.secretKey)
                .compact();
    }

    public boolean isValidJWTToken(String jwtToken){
        try {
            Jwts.parser().setSigningKey(this.secretKey).parseClaimsJws(jwtToken);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    public String getUsername(String token) {
        return Jwts.parser().setSigningKey(secretKey)
                .parseClaimsJws(token).getBody().getSubject();
    }

    public List<GrantedAuthority> getRoles(String token) {
        List<Map<String, String>>  roleClaims = Jwts.parser().setSigningKey(secretKey)
                .parseClaimsJws(token).getBody().get(ROLES_KEY, List.class);
        return roleClaims.stream().map(roleClaim ->
                new SimpleGrantedAuthority(roleClaim.get("authority")))
                .collect(Collectors.toList());
    }






}
