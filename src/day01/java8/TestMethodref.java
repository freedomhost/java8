package day01.java8;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.junit.Test;
/*
 *  一、方法引用：若Lambda体中的内容有方法已经实现了，我们可以使用“方法引用”
 *           （可以理解为方法引用是Lambda表达式的另外一种表现形式）
 *主要有三种语法格式：
 *对象::实例方法名
 *类::静态方法名
 *类::实例方法名
 *
 *   注意：
 * ①Lambda体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的函数列表和返回值类型保持一致
 * ②若Lambda参数列表中的第一个参数是实例方法的调用者，而第二个参数是实例方法的参数时，可以使用ClassName:method
 *
 *   二、构造器引用：
 *  格式：
 * ClassName::new
 *
 *   三、数组引用：
 *  格式：
 * Type::new
 */
public class TestMethodref {
	//对象::实例方法名
	@Test
	public void test1(){
		Consumer<String> con=(x)->System.out.println(x);
		Consumer<String> con2=System.out::println;
		con2.accept("helloworld");
	}
	@Test
	public void test2(){
		Employee emp=new Employee(11, "kobe", 12222);
		Supplier<String>sup=()->emp.getName();
		System.out.println(sup.get());
		Supplier<Integer>su=emp::getAge;
		System.out.println(su.get());
	}
	//类::静态方法名
	@Test
	public void test3(){
		Comparator<Integer>com=(x,y)->Integer.compare(x, y);
		Comparator<Integer>com2=Integer::compare;
	}
	//类::实例方法名
	@Test
	public void test4(){
		BiPredicate<String, String> bip=(x,y)->x.equals(y);
		BiPredicate<String, String> bip2=String::equals;
	}
	//构造器引用
	@Test
	public void test5(){
		Supplier<Employee>sup=()->new Employee();
		sup.get();
		Supplier<Employee>sup2=Employee::new;
		System.out.println(sup2.get());
	}
	//数组引用
	@Test
	public void test6(){
		Function<Integer,String[]>fun=(x)->new String[x];
		Function<Integer, String[]>fun2=String[]::new;
		String[]str=fun2.apply(5);
		System.out.println(str.length);
	}
}