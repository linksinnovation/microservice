#Microservice with Spring boot

### Create Maven Project and dependency
        <!-- Spring boot -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        
        <!-- Spring cloud -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-eureka-server</artifactId>
        </dependency>
        
        <!-- database -->
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
        </dependency>

### Create Main class
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

###Create Service Registry Main class
    @SpringBootApplication
    @EnableEurekaServer
    public class EurekaApplication {
        public static void main(String[] args) {
            System.setProperty("spring.config.name", "eureka-server");
            SpringApplication.run(EurekaApplication.class, args);
        }
    }

### add service Registry properties
    eureka.instance.hostname=localhost
    eureka.client.registerWithEureka=false
    eureka.client.fetchRegistry=false

    server.port=9000

### Create Service Api (Spring Boot Project)
    https://github.com/linksinnovation/springboot

### add Service api properties
    spring.application.name=comment-service
    eureka.client.serviceUrl.defaultZone=http://localhost:9000/eureka/
    server.port=9001


### Create Rest Client Service Main class
    @EnableAutoConfiguration
    @EnableDiscoveryClient
    @ComponentScan(basePackages = "com.linksinnovation.microservice.web")
    public class WebApplication {
        public static void main(String[] args) {
            System.setProperty("spring.config.name", "web-server");
            SpringApplication.run(WebApplication.class, args);
        }
    }

### Create Rest Client Service RestTemplate
    public interface CallerService {
        public List<Comment> get();
        public Comment post(Comment comment);
    }

    public class CommentCallerService implements CallerService{

        private static final String service = "http://COMMENT-SERVICE/comment/";

        @Autowired
        private RestTemplate restTemplate;

        @Override
        public List<Comment> get() {
            Comment[] get = restTemplate.getForObject(service, Comment[].class);
            return Arrays.asList(get);
        }

        @Override
        public Comment post(Comment comment) {
            return restTemplate.postForObject(service, comment, Comment.class);
        }

    }
    
### Create Rest client service Controller
    @RestController
    @RequestMapping("/comment")
    public class CommentController {

        @Autowired
        private CallerService callerService;

        @RequestMapping(method = RequestMethod.GET)
        public List<Comment> get() {
            return callerService.get();
        }

        @RequestMapping(method = RequestMethod.POST)
        public Comment post(@RequestBody Comment comment) {
            return callerService.post(comment);
        }

    }

### add Rest Client service properties
    spring.application.name=web-service
    eureka.client.serviceUrl.defaultZone=http://localhost:9000/eureka/

    server.port=9080