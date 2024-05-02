package com.example.springsecurityclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig
{
    private static final String[] WHITE_LIST_URLS = {
            "/hello",
            "/register",
            "/resendVerifyToken*",
            "/verifyRegistration*"
    };

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder( 11 );
    }

    @Bean
    SecurityFilterChain securityFilterChain( HttpSecurity httpSecurity ) throws Exception
    {
        httpSecurity
                .cors( cors -> cors.disable() )
                .csrf( csrf -> csrf.disable() )
                .authorizeRequests( authorize -> authorize.requestMatchers( WHITE_LIST_URLS ).permitAll());
//                                                          .requestMatchers( "/api/**" ).authenticated())
//                .oauth2Login( oauth2Login -> oauth2Login.loginPage( "/oauth2/authorization/api-client-oidc" ) )
//                .oauth2Client( Customizer.withDefaults() );
        return httpSecurity.build();
    }
}
    //     .cors()
//                .and()
//                .csrf()
//                .disable()
//                .authorizeHttpRequests()
//                .antMatchers().permitAll
//                .antMatchers("/api/**").auenticated()
//                .and()
//                .oauth2login(oauth2login ->
//                                   oauth2login.loginPage("/oauth2/authorization/api-client-oidc"))
//                .oauth2Client( Customizer.withDefaults());

