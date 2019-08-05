package day01.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import org.junit.Test;
public class TestLambda{
	List<Employee>employees =Arrays.asList(new Employee(18,"张三",9999.99),
			new Employee(38,"李四",5555.55),
			new Employee(50,"王五",6666.66),
			new Employee(16,"赵六",3333.33),
			new Employee(8,"田七",7777.77)
	);
	public List<Employee> filterEmps(FilterEmployees Filemp){
		List<Employee>list=new ArrayList<>();
		System.out.println();
		for(Employee e:employees)
			if(Filemp.FilterEmps(e))
				list.add(e);
		return list;

	}
	@Test
	public void test3(){
		List<Employee>list=filterEmps((e)->e.getSalary()>=7000);
		list.forEach(System.out::println);
	}


}