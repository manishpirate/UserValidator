package com.demo.springsecurityexample.config;

import com.demo.springsecurityexample.servlet.JWTAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.instrument.classloading.jboss.JBossLoadTimeWeaver;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SpringWebConfig extends WebSecurityConfigurerAdapter  {

    @Autowired
    CustomUserService customUserService;

    /**
     * This method is overriding the default spring security configuration. We are
     * adding the config based on the project default.
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin(form -> {
            form.loginPage("/login").defaultSuccessUrl("/main").permitAll();
        });
        http.authorizeRequests().antMatchers("/login/**").permitAll()
                .antMatchers("/signin").permitAll()
                .antMatchers("/h2-console").permitAll()
                .anyRequest().authenticated();

        http.csrf().disable();

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(new JWTAuthorizationFilter(customUserService), UsernamePasswordAuthenticationFilter.class);
    }

    /**
     * Authentication manager is the API for authentication.
      * @return
     * @throws Exception
     */
    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder(12);
    }

}
