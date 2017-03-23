package ccaiw.spring.cloud.server.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class TestController {
	private final Logger logger=Logger.getLogger(TestController.class);
	@Autowired
	DiscoveryClient client;
	@RequestMapping("/{id}")
	public String view(@PathVariable("id") Long id) {
		 ServiceInstance instance = client.getLocalServiceInstance();
		logger.info(id+"--------------"+instance.getPort());
		return String.valueOf(id);
	}
}
