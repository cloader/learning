 /**   
 * @Title: JacksonConfiguration.java 
 * @Package springboot.chapter2 
 * @Description: TODO
 * @author SirChen
 * @date 2017年3月9日 下午3:38:05 
 * @version V1.0   
 */
package springboot.chapter2;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

/** 
* @ClassName: JacksonConfiguration 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author SirChen
* @date 2017年3月9日 下午3:38:05 
*  
*/
@Configuration
public class JacksonConfiguration extends WebMvcConfigurerAdapter {
	 @Override
	    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	     System.out.println(converters);   
		 //converters.add(jacksonMessageConverter());
		 converters.add(new FastJsonHttpMessageConverter4());
		 //converters.add(new GsonHttpMessageConverter());
	        super.configureMessageConverters(converters);
	    }

	    private MappingJackson2HttpMessageConverter jacksonMessageConverter() {
	        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
	        ObjectMapper mapper = new ObjectMapper();
	        mapper.registerModule(new Hibernate5Module());
	        messageConverter.setObjectMapper(mapper);
	        return messageConverter;
	    }
	}
