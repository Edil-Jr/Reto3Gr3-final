package com.Reto3USA.Reto3Gr3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


//@Configuration
//@EnableAutoConfiguration
@ComponentScan (basePackages = {"com"})
@EntityScan(basePackages = {"com.modelo"})
@EnableConfigurationProperties
@SpringBootApplication


public class Reto3Gr3Application {

	public static void main(String[] args) {
		SpringApplication.run(Reto3Gr3Application.class, args);
                

}

}
        
        
        
        
       
