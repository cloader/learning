package ccaiw.spring.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Hello world!
 *
 */
@EnableEurekaServer
@SpringBootApplication
public class MySpringBootApplication2
{
    public static void main( String[] args )
    {
    	//SpringApplication.run(MySpringBootApplication.class);
    	new SpringApplicationBuilder(MySpringBootApplication2.class).web(true).run(args);
    }
}
