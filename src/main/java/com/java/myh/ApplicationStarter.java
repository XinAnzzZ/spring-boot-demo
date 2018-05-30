package com.java.myh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 心安
 * @date 2018/5/29 16:21
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.java.myh"})
public class ApplicationStarter {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationStarter.class, args);
    }

}

