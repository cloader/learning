package ccaiw.spring.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Hello world!
 *
 */
@EnableDiscoveryClient
@EnableEurekaServer
@SpringBootApplication
public class MySpringBootApplication 
{
    public static void main( String[] args )
    {
    	//SpringApplication.run(MySpringBootApplication.class);
    	new SpringApplicationBuilder(MySpringBootApplication.class).web(true).run(args);
    }
}
