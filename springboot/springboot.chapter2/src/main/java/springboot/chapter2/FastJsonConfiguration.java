 /**   
 * @Title: FastJsonConfiguration.java 
 * @Package springboot.chapter2 
 * @Description: TODO
 * @author SirChen
 * @date 2017年3月9日 下午4:41:42 
 * @version V1.0   
 */
package springboot.chapter2;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;

/** 
* @ClassName: FastJsonConfiguration 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author SirChen
* @date 2017年3月9日 下午4:41:42 
*  
*/
@Configuration
@ConditionalOnProperty(name = {"spring.http.converters.preferred-json-mapper"},
havingValue = "fastjson", 
matchIfMissing = true)
public class FastJsonConfiguration {
	
	@Bean
	public  FastJsonHttpMessageConverter4 fastJsonHttpMessageConverter(){
		return new FastJsonHttpMessageConverter4();
	}
}
