 /**   
 * @Title: User.java 
 * @Package springboot.chapter2.repository 
 * @Description: TODO
 * @author SirChen
 * @date 2017年3月9日 下午2:46:24 
 * @version V1.0   
 */
package springboot.chapter2.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/** 
* @ClassName: User 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author SirChen
* @date 2017年3月9日 下午2:46:24 
*  
*/
@Entity
@Table(name="aauser")
public class User implements Serializable{

	public User(){
		
	}
	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @param id
	* @param name
	* @param email 
	*/
	public User(Integer id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 1036628118255511535L;
	@Id
    @GeneratedValue
    private Integer id;
	private String name;
	private String email;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	/* (非 Javadoc) 
	* <p>Title: toString</p> 
	* <p>Description: </p> 
	* @return 
	* @see java.lang.Object#toString() 
	*/
	@Override
	public String toString() {
		return "id:"+this.id;
	}
}
