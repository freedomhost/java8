package day01.java8;

import java.util.ArrayList;
import java.util.List;

public class FilterSalary implements FilterEmployees{
 @Override
public boolean FilterEmps(Employee e) {
	// TODO Auto-generated method stub
	return e.getSalary()>=5000;
}
}
