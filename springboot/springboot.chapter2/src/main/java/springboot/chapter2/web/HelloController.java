package springboot.chapter2.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.chapter2.entity.User;
import springboot.chapter2.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class HelloController {
	
	@Autowired
	private UserRepository userRepository;
	@RequestMapping("/{id}")
	public User index(@PathVariable("id") int id) {
		System.out.println(id);
		User user=userRepository.getOne(id);
		System.out.println(user);
		return user;
	}
}
