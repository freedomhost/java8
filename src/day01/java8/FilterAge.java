package day01.java8;

import java.util.ArrayList;
import java.util.List;


public class FilterAge implements FilterEmployees{
      @Override
    public boolean FilterEmps(Employee e) {
    	// TODO Auto-generated method stub
    	return e.getAge()>=35;
    }
}
