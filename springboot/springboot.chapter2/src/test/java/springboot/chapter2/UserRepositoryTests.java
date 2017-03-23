 /**   
 * @Title: UserRepositoryTests.java 
 * @Package springboot.chapter2 
 * @Description: TODO
 * @author SirChen
 * @date 2017年3月9日 下午3:02:23 
 * @version V1.0   
 */
package springboot.chapter2;

import org.jboss.jandex.Main;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springboot.chapter2.entity.User;
import springboot.chapter2.repository.UserRepository;

/** 
* @ClassName: UserRepositoryTests 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author SirChen
* @date 2017年3月9日 下午3:02:23 
*  
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Chapter2Application.class)
public class UserRepositoryTests {
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void test() throws Exception {
		
		userRepository.save(new User(1, "aa@126.com", "aa@126.com"));
		userRepository.save(new User(2, "bb@126.com", "bb@126.com"));
		userRepository.save(new User(3, "cc@126.com","cc@126.com"));

		Assert.assertEquals(3, userRepository.findAll().size());
		Assert.assertEquals(new Integer(3), userRepository.findByNameOrEmail("bb", "cc@126.com").getId());
		userRepository.delete(userRepository.findByName("aa@126.com"));
	}
	
	public static void main(String[] args) {
		String lines=""/** ~{111,1}*/;
		System.out.println(lines);
	}
}
