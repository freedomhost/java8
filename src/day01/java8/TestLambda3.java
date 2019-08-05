package day01.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;
/*
 * Java8 内置的四大核心函数式接口
 *
 * Consumer<T>: 消费型接口
 *       void accept(T t);
 * Supplier<T>:供给型接口
 *       T get();
 * Function<T,R>:函数型接口
 *       R apply(T t);
 * Predicate<T>:断言型接口
 *       boolean test(T t);
 */

public class TestLambda3 {
	public <T>void happy(T money,Consumer<T> c){
		c.accept(money);
	}
	@Test
	public void test1(){
		happy(10000,(x)->System.out.println("消费了"+x+"大元"));
	}
	public List<Integer> getNumList(Integer num,Supplier<Integer> su){
		List<Integer> list=new ArrayList<>();
		for(int i=0;i<num;i++){
			list.add(su.get());
		}
		return list;
	}
	@Test
	public void test2(){
		List<Integer>list=getNumList(5,()->{
			Random r=new Random();
			return r.nextInt(1000);
		});
		list.stream().forEach(System.out::println);
	}
	public <T,R>R Handlerstr(T str,Function<T,R>fun){
		return fun.apply(str);
	}
	@Test
	public void test3(){
		String str=Handlerstr("  wo yao nuli le  ",(x)->x.trim());
		System.out.println(str);
		int length=Handlerstr(str, (x)->x.length());
		System.out.println("字符串的长度是:"+length);
	}
	public List<String>filterString(List<String>list,Predicate<String> pre){
		List<String>listNew=new ArrayList<>();
		for(String str:list)
			if(pre.test(str))
				listNew.add(str);
		return listNew;
	}
	@Test
	public void test4(){
		List<String>list=Arrays.asList("james","kobe","ben","durant","knift");
		List<String>listNew=filterString(list,(x)->x.length()>=4);
		listNew.stream().forEach(System.out::println);
	}
}