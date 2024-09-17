package com.shashi.config;

import com.shashi.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(Authorize -> Authorize
//	                		.requestMatchers("/api/admin/**").hasRole("ADMIN")
                                .requestMatchers("/api/**").authenticated()

                                .anyRequest().permitAll()
                )
                .oauth2Login(oauth->{
                    oauth.loginPage("/login/google");
                    oauth.authorizationEndpoint(authorization->
                            authorization.baseUri("/login/oauth2/authorization"));
                    oauth.successHandler(new AuthenticationSuccessHandler() {

                        @Override
                        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                                            Authentication authentication) throws IOException, ServletException {

                            if(authentication.getPrincipal() instanceof DefaultOAuth2User userDetails) {
                                String email = userDetails.getAttribute("email");
                                String fullName=userDetails.getAttribute("name");
                                String phone=userDetails.getAttribute("phone");
                                String picture=userDetails.getAttribute("picture");
                                boolean email_verified= Boolean.TRUE.equals(userDetails.getAttribute("email_verified"));

                                User user=new User();
                                user.setVerified(email_verified);
                                user.setFullName(fullName);
                                user.setEmail(email);
                                user.setMobile(phone);
                                user.setPicture(picture);

                                System.out.println("--------------- " + email+
                                        "-------------"+
                                        "==========="
                                        +"-------"+user);
                            }

                        }
                    });
                })
                .addFilterBefore(new JwtTokenValidator(), BasicAuthenticationFilter.class)
                .csrf(AbstractHttpConfigurer::disable)
                .cors(cors -> cors.configurationSource(corsConfigurationSource()));


        return http.build();

    }

    // CORS Configuration
    private CorsConfigurationSource corsConfigurationSource() {
        return new CorsConfigurationSource() {
            @Override
            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                CorsConfiguration cfg = new CorsConfiguration();
                cfg.setAllowedOrigins(Arrays.asList(
                        "http://localhost:3000",
                        "http://localhost:5173",
                        "http://localhost:5174",
                        "http://localhost:8080",
                        "https://trade-bot-backend.onrender.com",
                        "https://trade-bot-frontend.onrender.com"
                ));
                cfg.setAllowedMethods(Collections.singletonList("*"));
                cfg.setAllowCredentials(true);
                cfg.setAllowedHeaders(Collections.singletonList("*"));
                cfg.setExposedHeaders(List.of("Authorization"));
                cfg.setMaxAge(3600L);
                return cfg;
            }
        };
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}

