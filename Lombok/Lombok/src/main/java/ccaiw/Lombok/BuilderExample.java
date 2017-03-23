 /**   
 * @Title: BuilderExample.java 
 * @Package ccaiw.Lombok 
 * @Description: TODO
 * @author SirChen
 * @date 2017年3月23日 上午11:09:50 
 * @version V1.0   
 */
package ccaiw.Lombok;

import java.util.Set;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import lombok.extern.java.Log;

/** 
* @ClassName: BuilderExample 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author SirChen
* @date 2017年3月23日 上午11:09:50 
*  
*/
@Builder
@Data
@Log
public class BuilderExample {
	@Builder.Default
	private Long created=System.currentTimeMillis();
	private String name;
	private int age;
	@Singular private Set<String> occupations;
}
