package com.linksinnovation.microservice;

import com.linksinnovation.microservice.comment.CommentApplication;
import com.linksinnovation.microservice.eureka.EurekaApplication;
import com.linksinnovation.microservice.web.WebApplication;
import org.springframework.boot.SpringApplication;

/**
 *
 * @author Jirawong Wongdokpuang <greannetwork@gmail.com>
 */
public class Application {
    public static void main(String[] args) {
        switch(args.length){
            case 2:
                System.setProperty("spring.config.name", args[0] + "-server");
                System.setProperty("server.port", args[1]);
                break;
            case 1:
                System.setProperty("spring.config.name", args[0] + "-server");
                break;
            default:
                usage();
                return;
        }
        
        switch(args[0]){
            case "web":
                SpringApplication.run(WebApplication.class, args);
                break;
            case "comment":
                SpringApplication.run(CommentApplication.class, args);
                break;
            case "eureka":
                SpringApplication.run(EurekaApplication.class, args);
                break;
            default:
                available();
        }
    }
    
    private static void usage(){
        System.out.println("Usage: java -jar <jar-file> <server-name> [server-port]");
        System.out.println("Example:");
        System.out.println("    java -jar target/microservice-1.0.0-SNAPSHOT.jar web 80");
    }
    
    private static void available(){
        System.out.println("server available for \"web\", \"comment\" and \"eureka\"");
    }
}
