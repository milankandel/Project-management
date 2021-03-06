/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milan.app;

import com.fasterxml.jackson.databind.JsonSerializable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author ACER
 */
@SpringBootApplication
@EnableJpaRepositories({"com.milan.app.repository"})
@EntityScan(basePackages = "com.milan.app.entity")
@EnableTransactionManagement
public class AppStarter {
   public static void main(String[] args)
   {
       SpringApplication.run(AppStarter.class, args);
   }
}
