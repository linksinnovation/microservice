package com.linksinnovation.microservice.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author Jirawong Wongdokpuang <greannetwork@gmail.com>
 */
@EnableAutoConfiguration
@EnableDiscoveryClient
@ComponentScan(basePackages = "com.linksinnovation.microservice.web")
public class WebApplication {
    public static void main(String[] args) {
        System.setProperty("spring.config.name", "web-server");
        SpringApplication.run(WebApplication.class, args);
    }
}
