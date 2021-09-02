package com.qltc.springqltc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.qltc.springqltc.*")
@SpringBootApplication
public class SpringQltcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringQltcApplication.class, args);
    }

}
