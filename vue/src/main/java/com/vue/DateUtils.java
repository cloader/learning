 /**   
 * @Title: DateUtils.java 
 * @Package com.vue 
 * @Description: TODO
 * @author SirChen
 * @date 2017年3月21日 下午12:45:03 
 * @version V1.0   
 */
package com.vue;

import java.sql.Date;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.eclipse.jdt.internal.compiler.batch.Main;

/** 
* @ClassName: DateUtils 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author SirChen
* @date 2017年3月21日 下午12:45:03 
*  
*/
public class DateUtils {
	public static void main(String[] args) throws InterruptedException {
		LocalDate date=LocalDate.now();
		date=date.plusYears(1);
		System.out.println(date.parse("20160205",DateTimeFormatter.BASIC_ISO_DATE));
		System.out.println(date.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
		System.out.println(date.getDayOfYear());
		LocalDateTime datetime=LocalDateTime.now();
		System.out.println(datetime.getHour());
		date=LocalDate.of(1000, 2, 28);
		System.out.println(date);
		System.out.println(date.equals(datetime));
		long start=System.currentTimeMillis();
		System.out.println(start);
		Clock clock=Clock.systemUTC();
		System.out.println(Clock.systemUTC().millis());
		Thread.sleep(1000);
		System.out.println(Clock.systemUTC().millis()-start);
		System.out.println(Clock.systemUTC().millis());
		System.out.println(Clock.systemUTC().equals(clock));
		//ZoneId.getAvailableZoneIds().forEach(a->System.out.println(a));
		
	}
}
