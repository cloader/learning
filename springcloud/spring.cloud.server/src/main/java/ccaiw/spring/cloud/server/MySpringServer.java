package ccaiw.spring.cloud.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class MySpringServer 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(MySpringServer.class);
    }
}
