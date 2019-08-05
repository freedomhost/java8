package day02.java8;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

import org.junit.Test;

public class TestForkJoin {
	/*
	 * ForkJoin框架
	 */
	@Test
	public void test1(){
		Instant start=Instant.now();
		ForkJoinPool pool=new ForkJoinPool();
		ForkJoinTask<Long> task=new ForkJoinCalculate(0, 10000000000L);
		Long sum=pool.invoke(task);
		System.out.println(sum);
		Instant end=Instant.now();
		System.out.println("耗费时间为： "+Duration.between(start, end).toMillis()); // 281
	}
	@Test
	public void test2(){
		Instant start=Instant.now();
		long sum=0;
		for(long i=0;i<=10000000000L;i++)
			sum+=i;
		System.out.println(sum);
		Instant end=Instant.now();
		System.out.println("耗费时间为: "+Duration.between(start, end).toMillis()); //77
	}
	//java8 并行流
	@Test
	public void test3(){
		Instant start=Instant.now();
		long sum=LongStream.rangeClosed(0, 10000000000L)
				.parallel()
				.reduce(0,Long::sum);
		Instant end=Instant.now();
		System.out.println(sum);
		System.out.println("耗费时间为: "+Duration.between(start,end).toMillis());
	}
}