package com.gowsik.auth_service.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

   @Bean
   public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

       //All request should be authenticated
       httpSecurity.authorizeHttpRequests(auth -> auth.requestMatchers("/home", "/home/", "/home/index.html",
               "/home/**")
       .permitAll()
       .anyRequest()
       .authenticated());

       //If request not authenticated show web page popup for authentication
       httpSecurity.httpBasic(Customizer.withDefaults());

       //Disabled for CSRF request
       httpSecurity.csrf(AbstractHttpConfigurer::disable);


       return httpSecurity.build();
   }
}
