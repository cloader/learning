package ccaiw.spring.cloud.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
	@Autowired
    RestTemplate restTemplate;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
		System.out.println("------------------");
        return restTemplate.getForEntity("http://COMPUTE-SERVICE/test/1", String.class).getBody();
    }
}
