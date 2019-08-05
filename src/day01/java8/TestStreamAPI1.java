package day01.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

/*
 * 一、Stream的三个操作步骤：
 *    1.创建Stream
 *    2.中间操作
 *    3.终止操作（终端操作）
 */
public class TestStreamAPI1 {
	// 创建Stream
	@Test
	public void test1() {
		// 1.可以通过Collection系列集合提供的stream()、或parallelStream()
		List<String> list = new ArrayList<>();
		Stream<String> stream1 = list.stream();

		// 2.通过Arrays中的静态方法stream()获取数组流
		Employee[] emps = new Employee[10];
		Stream<Employee> stream2 = Arrays.stream(emps);

		// 3.通过Stream类中的静态方法of()
		Stream<String> stream3 = Stream.of("aa", "bb", "cc");

		//迭代
		Stream.iterate(0, (x) -> x + 2).limit(10).forEach(System.out::println);;
		//生成
		Stream.generate(()->Math.random()).limit(4).forEach(System.out::println);;
	}

}