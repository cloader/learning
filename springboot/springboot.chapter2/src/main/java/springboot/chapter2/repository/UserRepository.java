 /**   
 * @Title: UserRepository.java 
 * @Package springboot.chapter2.repository 
 * @Description: TODO
 * @author SirChen
 * @date 2017年3月9日 下午2:35:51 
 * @version V1.0   
 */
package springboot.chapter2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.chapter2.entity.User;

/** 
* @ClassName: UserRepository 
* @Description: 持久层
* @author SirChen
* @date 2017年3月9日 下午2:35:51 
*  
*/
public interface UserRepository  extends JpaRepository<User,Integer>{
	User findByName(String name);
    User findByNameOrEmail(String name, String email);
}
