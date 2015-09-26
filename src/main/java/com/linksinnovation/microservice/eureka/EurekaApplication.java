package com.linksinnovation.microservice.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *
 * @author Jirawong Wongdokpuang <greannetwork@gmail.com>
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
    public static void main(String[] args) {
        System.setProperty("spring.config.name", "eureka-server");
        SpringApplication.run(EurekaApplication.class, args);
    }
}
