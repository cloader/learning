 /**   
 * @Title: Test.java 
 * @Package ccaiw.Lombok 
 * @Description: TODO
 * @author SirChen
 * @date 2017年3月23日 上午10:58:53 
 * @version V1.0   
 */
package ccaiw.Lombok;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import lombok.val;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

/** 
* @ClassName: Test 
* @Description: (这里用一句话描述这个类的作用) 
* @author SirChen
* @date 2017年3月23日 上午10:58:53 
*  
*/
@Log
public class LombokTest {
	
	@Test
	public void setget(){
		App app=new App();
		app.setCode("123");
		app.setName("456");
		System.out.println(app.toString());
		val a=new String("1");
		System.out.println(a);
		val example = new ArrayList<String>();
		example.add("Hello, World!");
		val foo = example.get(0);
		System.out.println(foo.toCharArray());
	}
	
	@Test
	public void builderTest(){
		BuilderExample example=BuilderExample.builder().age(1).build();
		Assert.assertEquals(example.getAge(), 1);
	}
}
