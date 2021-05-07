package com.demo.springsecurityexample.config;

import com.demo.springsecurityexample.entity.User;
import com.demo.springsecurityexample.entity.UserRoles;
import com.demo.springsecurityexample.repository.RoleRepository;
import com.demo.springsecurityexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

import static org.springframework.security.core.userdetails.User.withUsername;

@Component
public class CustomUserService implements UserDetailsService {

    Logger log = Logger.getLogger("CustomUserService.class");

    PasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    JWTProvider jwtProvider;


    /**
     * This method will be called to fetch the user details from the database and create the user
     * Details from the user object.
     * @param s
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
         User user = userRepository.findUserByUserName(s).orElseThrow( () -> {
                 throw new UsernameNotFoundException("User Not Found");
         });

         //now we will fetch the user roles from the user we have just received
         Set<UserRoles> userRoles = roleRepository.getUserRolesByUserId(user.getId());
         user.setUserRoles(userRoles);

         userRoles.stream().forEach(role -> log.info(role.getRoleName() + " "  +role.getAuthority()));

         return withUsername(user.getUserName()).password(user.getPassword())
                 .authorities(user.getUserRoles())
                 .accountExpired(false)
                 .accountLocked(false)
                 .credentialsExpired(false)
                 .disabled(false)
                 .build();
    }


    public Optional<UserDetails> loadUserByJWTToken(String token){
        //first we will check if token is valid
        if(jwtProvider.isValidJWTToken(token)) {
            return Optional.of(
                    withUsername(jwtProvider.getUsername(token))
                    .authorities(jwtProvider.getRoles(token))
                    .password("")
                    .accountExpired(false)
                    .accountLocked(false)
                    .disabled(false)
                    .credentialsExpired(false)
                    .build());
        }else {
            return Optional.empty();
        }
    }
}
