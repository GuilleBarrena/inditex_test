package com.inditex.guillermobarrena.inditex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("com.inditex.guillermobarrena")
@SpringBootApplication
public class IndiTexApplication {

    public static void main(String[] args) {
        SpringApplication.run(IndiTexApplication.class, args);
    }
}
