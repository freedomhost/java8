package day01.exer;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestStreamAPI {
   @Test
   public void test1(){
	   Integer num[]=new Integer[]{1,2,3,4,5};
	   Arrays.stream(num).map((x)->x*x).forEach(System.out::println);
	  
   }
}
