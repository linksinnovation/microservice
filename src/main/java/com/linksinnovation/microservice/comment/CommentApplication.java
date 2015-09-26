package com.linksinnovation.microservice.comment;

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
@ComponentScan(basePackages = "com.linksinnovation.microservice.comment")
public class CommentApplication {
    public static void main(String[] args) {
        System.setProperty("spring.config.name", "comment-server");
        SpringApplication.run(CommentApplication.class, args);
    }
}
