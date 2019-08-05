package day02.java8;

import org.junit.Test;

import java.util.Date;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Locale;
import java.util.Set;



public class TestNewDateAPI {
	//1.LocalDate LocalTime LocalDateTime
	@Test
	public void test1(){
		LocalDateTime ldt=LocalDateTime.now();
		System.out.println(ldt);
		LocalDateTime ldt2=LocalDateTime.of(2015, 10,12,15,32,34);
		System.out.println(ldt2);
		LocalDateTime ldt3=ldt.plusYears(2);
		System.out.println(ldt3);
		LocalDateTime ldt4=ldt.minusMonths(3);
		System.out.println("ldt4: "+ldt4);
		System.out.println(ldt.getYear());
		System.out.println(ldt.getMonthValue());
		System.out.println(ldt.getDayOfMonth());
	}
	//2.Instant: 时间戳（以Unix元年：1970年1月1日00：00：00到某个时间之间的毫秒值）
	@Test
	public void test2(){
		Instant ins1=Instant.now();
		System.out.println(ins1);
		OffsetDateTime odt=ins1.atOffset(ZoneOffset.ofHours(8));
		System.out.println(odt);
		System.out.println(odt.toEpochSecond());
		System.out.println("---------------");
		Instant ins2=Instant.ofEpochSecond(10);
		System.out.println(ins2);
	}
	/*
	   3.
	   Duration:计算两个“时间”之间的间隔
	   Period：计算两个“日期”之间的间隔
	 */
	@Test
	public void test3(){
		Instant ins1=Instant.now();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Instant ins2=Instant.now();
		Duration duration=Duration.between(ins1,ins2);
		System.out.println(duration.toMillis());
		System.out.println("----------------------------");
		LocalTime lt1=LocalTime.now();
		try {
			Thread.sleep(1200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LocalTime lt2=LocalTime.now();
		System.out.println(Duration.between(lt1, lt2).toMillis());
	}
	@Test
	public void test4(){
		LocalDate ld1=LocalDate.of(2020, 07, 01);
		LocalDate ld2=LocalDate.now();
		Period period=Period.between(ld2, ld1);
		System.out.println("aa "+period.getMonths());
		System.out.println(period);
	}
	//TemporalAdjuster:时间校正器
	@Test
	public void test5(){
		LocalDateTime ldt=LocalDateTime.now();
		System.out.println(ldt);
		LocalDateTime ldt2=ldt.withDayOfMonth(12);
		System.out.println(ldt2);
		LocalDateTime ldt3=ldt.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
		System.out.println(ldt3);
		//自定义
		LocalDateTime ldt5=ldt.with((e)->{
			LocalDateTime ldt4=(LocalDateTime)e;
			DayOfWeek dow=ldt4.getDayOfWeek();
			if(dow.equals(DayOfWeek.FRIDAY)){
				return	ldt4.plusDays(3);
			}
			else if(dow.equals(DayOfWeek.SATURDAY)){
				return ldt4.plusDays(2);
			}
			else
				return ldt4.plusDays(1);
		});
		System.out.println(ldt5);
	}
	//DateTimeFormatter: 格式化时间/日期
	@Test
	public void test6(){
		DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
		LocalDateTime ldt = LocalDateTime.now();
		String strfDate=ldt.format(dtf);
		System.out.println(strfDate);
		System.out.println("----------------------");
		DateTimeFormatter dtf2=DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
		String strDate2=dtf2.format(ldt);
		System.out.println(strDate2);
		LocalDateTime ldt3=ldt.parse(strDate2,dtf2);
		System.out.println(ldt3);
	}
	//ZonedDate ZonedTime ZonedDateTime
	@Test
	public void test7(){
		Set<String> set=ZoneId.getAvailableZoneIds();
		set.forEach(System.out::println);
	}
	@Test
	public void test8(){
		LocalDateTime ldt=LocalDateTime.now(ZoneId.of("America/New_York"));
		System.out.println(ldt);
		LocalDateTime ldt2=LocalDateTime.now();
		ZonedDateTime zdt=ldt2.atZone(ZoneId.of("America/New_York"));
		System.out.println(zdt);
	}

	@Test
	public void test9() {
		Instant start = Instant.now();
		System.out.println("-------");
		Instant end = Instant.now();
		long millis = Duration.between(start,end).toMillis();
		System.out.println("mi: "+millis);
	}

}
