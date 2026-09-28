package com.itvedant.jwtsecurity.JWTApplication1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AppConfig
{
@Bean
 public UserDetailsService userDetailsService()
 {
     UserDetails usr1 = User.builder().username("Pratik")
             .password(passwordEncoder().encode("pratik@1234"))
             .roles("Admin").build();
     UserDetails usr2 = User.builder().username("Sayali")
             .password(passwordEncoder().encode("sayali@1234"))
             .roles("Admin").build();
     UserDetails usr3 = User.builder().username("Kanchan")
             .password(passwordEncoder().encode("kanchan@1234"))
             .roles("Admin").build();
     UserDetails usr4 =User.builder().username("Madhuri")
             .password(passwordEncoder().encode("madhuri@123"))
             .roles("Admin").build();
     return new InMemoryUserDetailsManager(usr1,usr2,usr3,usr4);
 }
 @Bean
 public PasswordEncoder passwordEncoder()
 {
     return new BCryptPasswordEncoder();
 }
}
