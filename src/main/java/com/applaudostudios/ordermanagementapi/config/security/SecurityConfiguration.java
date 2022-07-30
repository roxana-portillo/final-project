package com.applaudostudios.ordermanagementapi.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.DefaultSecurityFilterChain;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Bean
    public DefaultSecurityFilterChain securityWebFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeExchange()
//                //ALLOWING REGISTER API FOR DIRECT ACCESS
//                .pathMatchers("/user/api/v1/register").permitAll()
//                //ALL OTHER APIS ARE AUTHENTICATED
//                .anyExchange().authenticated()
//                .and()
//                .csrf().disable()
//                .oauth2Login()
//                .and()
//                .oauth2ResourceServer()
//                .jwt();
//        return http.build();

//        http
//                .authorizeExchange()
//                .pathMatchers("/user/api/v1/register")
//                .permitAll()
//                .and()
//                .authorizeExchange()
//                .anyExchange().authenticated()
//                .and()
//                .oauth2ResourceServer()
//                .jwt();
//        return http.build();

        http
                .authorizeRequests()
                .antMatchers("/")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Client().and().logout().logoutSuccessUrl("/");
        return http.build();
    }
}
