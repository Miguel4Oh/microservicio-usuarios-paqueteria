package com.ortegamiguel.usuariospaqueteria.security;

import com.ortegamiguel.usuariospaqueteria.security.filter.AuthenticationFilerJWT;
import com.ortegamiguel.usuariospaqueteria.security.filter.ValidationFilterJwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

     @Autowired
     private AuthenticationConfiguration authenticationConfiguration;

     @Bean
     AuthenticationManager authenticationManager() throws Exception {
          return authenticationConfiguration.getAuthenticationManager();
     }

     @Bean
     public PasswordEncoder passwordEncoder(){
          return new BCryptPasswordEncoder();
     }

     @Bean
     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
          http.authorizeHttpRequests((authorize)-> authorize
                  .requestMatchers(HttpMethod.GET, "/paqueteria/v0/users/users")
                          .hasAnyRole("GERENTE", "COORDINADOR", "SUPERVISOR", "ALMACENISTA")
                          .requestMatchers(HttpMethod.PATCH, "/paqueteria/v0/users/user")
                          .hasAnyRole("GERENTE", "COORDINADOR")
                          .requestMatchers(HttpMethod.POST, "/paqueteria/v0/users/user")
                          .hasAnyRole("GERENTE", "COORDINADOR", "SUPERVISOR", "ALMACENISTA")
                          .requestMatchers(HttpMethod.DELETE, "/paqueteria/v0/users/user")
                          .hasAnyRole("GERENTE", "COORDINADOR")
                  .anyRequest()
                  .authenticated())
                  .addFilter(new AuthenticationFilerJWT(authenticationManager()))
                  .addFilter(new ValidationFilterJwt(authenticationManager()))
                  .csrf(config -> config.disable())
                  .sessionManagement(management -> management
                          .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

          return http.build();
     }
}
