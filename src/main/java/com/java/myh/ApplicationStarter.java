package com.java.myh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author 心安
 * @date 2018/5/29 16:21
 *
 * 配置druid必须加 @ServletComponentScan 注解，如果不加，访问监控页面打不开，
 * filter和servlet、listener之类的需要单独进行注册才能使用，
 * spring boot里面提供了该注解起到注册作用
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.java.myh.repository")
@ServletComponentScan
@ComponentScan(basePackages = {"com.java.myh"})
public class ApplicationStarter {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStarter.class, args);
    }
}

