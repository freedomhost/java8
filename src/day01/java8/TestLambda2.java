package day01.java8;

import java.util.Comparator;
import java.util.function.Consumer;

import org.junit.Test;


/*
 * 一、Lambda表达式的基础语法：java8中引入了一个新的操作符"->" 该操作符称为箭头操作符或Lambda操作符
 *                            箭头操作符Lambda表达式拆分成两部分：
 *     左侧：Lambda表达式的参数列表
 *     右侧：Lambda表达式中所需执行的功能，即Lambda体
 *
 *     语法格式一：无参数，无返回值
 *                 （）->System.out.println("Hello Lambda");
 *     语法格式二：有一个参数，无返回值
 *                 （x）->System.out.println(x);
 *     语法格式三：若只有一个参数，小括号可以忽略不写
 *                   x->System.out.println(x);
 *     语法格式四：有两个以上的参数，有返回值，并且Lambda体有多条表示式
 *                  Comparator<Integer> com=(x,y)->{ };
 *     语法格式五：Lambda体只有一条表达式，return和大括号都可以忽略不写
 *                  Comparator<Integer>con=(x,y)->Integer.compare(x,y);
 *     语法格式六：Lambda表达式的参数列表的数据类型可以忽略不写，因为JVM编译器可以通过上下文推断出，即“类型推断”
 *                  (Integer x,Integer y)->Integer.compare(x,y);
 *--总结--
 *横批：能省则省
 *上联：左右遇一括号省
 *下联：左侧推断类型省
 *
 * 二、 Lambda表达式 需要“函数式接口”的支持
 * 函数式接口：接口中只有一个抽象方法，称为函数式接口。可以使用@FunctionalInterface修饰
 *            可以检查该接口是否为函数式接口
 */
public class TestLambda2 {
	@Test
	public void test1(){
		int num=0;
		Runnable r=new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello Lambda"+num);
			}
		};
		r.run();
		System.out.println("------------------------------");
		Runnable run=()->System.out.println("Hello Lambda2"+num);
		run.run();
	}
	@Test
	public void test2(){
		Consumer<String> con=(x)->System.out.println(x);
		con.accept("wo ai java");
	}
	@Test
	public void test3(){
		Comparator<Integer> com=(x,y)->{
			System.out.println("wo shi lai da jiang you de ");
			return Integer.compare(x, y);
		};
	}
	@Test
	public void test4(){
		Comparator<Integer>con=(x,y)->Integer.compare(x, y);
	}
	@Test
	public void test5(){
		Integer num=operation(100,(x)->x+x);
		System.out.println(num);
	}
	public Integer operation(Integer num,MyFun myFun){
		return myFun.getValue(num);
	}
}
