 /**   
 * @Title: ClientTest.java 
 * @Package ccaiw.Lombok 
 * @Description: TODO
 * @author SirChen
 * @date 2017年3月28日 下午12:20:31 
 * @version V1.0   
 */
package ccaiw.Lombok;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/** 
* @ClassName: ClientTest 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author SirChen
* @date 2017年3月28日 下午12:20:31 
*  
*/
public class ClientTest {
public static void main(String[] args) throws ClientProtocolException, IOException {
	CloseableHttpClient httpclient = HttpClients.createDefault();
	HttpPost post=new HttpPost("https://hv5.basiapp.com/MyCard/GetTopUp?t=0.09942109544664324");
			//post.setParams(params);
	List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
    formparams.add(new BasicNameValuePair("cardno", "16114544"));  
	UrlEncodedFormEntity entiry=new UrlEncodedFormEntity(formparams);
	post.setEntity(entiry);
	//post.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36");
	//post.setHeader("Referer", "https://hv5.basiapp.com/mycard/topup?idCard=16114544");
	post.setHeader("Content-Type","application/x-www-form-urlencoded");
	post.setHeader("X-Requested-With","XMLHttpRequest");
	CloseableHttpResponse res=httpclient.execute(post);
	System.out.println(post.toString());
	System.out.println(EntityUtils.toString(res.getEntity()));
	
}
}
