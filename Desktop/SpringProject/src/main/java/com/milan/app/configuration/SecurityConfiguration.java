/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milan.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



/**
 *
 * @author ACER
 */
@Configuration
@EnableWebSecurity

public class SecurityConfiguration extends  WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.authorizeRequests()
               .anyRequest()
               .authenticated()
               .and()
               .formLogin().loginPage("/login")
               .usernameParameter("username")
               .passwordParameter("password")
              
               .permitAll().and()
               .logout()
               .permitAll().invalidateHttpSession(true);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/webjars/**","/assets/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(gePasswordEncoder())
                .withUser("admin")
                .password(gePasswordEncoder().encode("milan"))
                .roles("ADMIN");
             
             
                
    }
    
    @Bean
    public BCryptPasswordEncoder gePasswordEncoder(){
       return  new BCryptPasswordEncoder(); 
    }
    
    
}

