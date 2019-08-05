package day02.java8;

import java.util.Optional;

import org.junit.Test;

public class TestOptional {
	/*
        Optional 容器类的常用方法：
        Optional.of(T T)：创建一个Optional实例
        Optional.empty(): 创建一个空的Optional实例
        Optional.ofNullable(T t):若t不为null，创建Optional实例，否则创建空实例
        isPresent():判断是否包含值
        orElse(T t):如果调用包含值，返回改值，否则返回t
        orElseGet(Supplier s):如果调用对象包含值，返回该值，否则返回s获取的值
        map(Function f):如果值对其处理，并返回处理后的Optional，否则返回Optional.empty()
        flatMap(Function mapper): ；与map类似，要求返回值必须是Optional
     */
	@Test
	public void test5(){
		Optional<Employee> op=Optional.ofNullable(new Employee(113,"coco",8988.98));
		Optional<Integer> age=op.flatMap((e)->Optional.ofNullable(e.getAge()));
		System.out.println(age.get());
	}
	@Test
	public void test4(){
		Optional<Employee> op=Optional.ofNullable(null);
		Object obj=op.orElseGet(()->new Employee());
		System.out.println(obj);
	}
	@Test
	public void test3(){
		Optional op=Optional.ofNullable(null);
		if(op.isPresent())
			System.out.println(op.get());
	}
	@Test
	public void test2(){
		Optional op=Optional.empty();
		System.out.println(op);
	}
	@Test
	public void test1(){
		Optional<Employee> op=Optional.of(null);
		Employee emp=op.get();
		System.out.println(emp);
	}
	//例题
	@Test
	public void test6(){
		Man man=new Man();
		String n=getGodnessName(man);
//		System.out.println(n);
	}
	//需求: 获取一个男人心中女神的名字
	public String getGodnessName(Man man){
		return man.getGodness().getName();
	}
	public String getNewGodnessName(Optional<NewMan> man){
		return man.orElse(new NewMan())
				.getGodness()
				.orElse(new Godness("lily"))
				.getName();
	}
}