package day01.exer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Handler;

import org.junit.Test;
public class TestLambda {
	List<Employee>emps=Arrays.asList(new Employee(18,"??",9999.99),
			new Employee(59,"??",6666.66),
			new Employee(18,"??",3333.33),
			new Employee(9,"??",7777.77),
			new Employee(39,"??",2222.22));
	@Test
	public void test1(){
		Collections.sort(emps,(x,y)->{
			if(x.getAge()==y.getAge())
				return x.getName().compareTo(y.getName());
			else
				return Integer.compare(x.getAge(),y.getAge());
		});
		emps.stream().forEach(System.out::println);
	}
	@Test
	public void test2(){
		String str=strHandler("  jiang you   \t  ", (x)->x.trim());
		System.out.println(str);
		String str1=strHandler("abcde",(x)->x.toUpperCase());
		System.out.println(str1);
		String str2=strHandler("???????",(x)->x.substring(2,4));
		System.out.println(str2);

	}
	public String strHandler(String str,Myfunction mf){
		return mf.getValue(str);
	}
	public <T,R>void op(T d1,T d2,myFunction2<T,R> mf){
		System.out.println(mf.getValue(d1,d2));
	}
	@Test
	public void test3(){
		op(5,3,(x,y)->x+y);
	}

}