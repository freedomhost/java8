package day02.exer;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;


public class TestTransaction {
	
	List<Transaction> transactions = null;
	
	@Before
	public void before(){
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		
		transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)
		);
	}
    //1.找出2011年发生的所有交易，并按交易额排序（从低到高）
	@Test
	public void test1(){
		transactions.stream().filter((t)->t.getYear()==2011)
                             .sorted((x,y)->Integer.compare(x.getValue(),y.getValue()))
		                     .forEach(System.out::println);
	}
	//2.交易员工作的城市
	@Test
	public void test2(){
		transactions.stream().map((t)->t.getTrader().getCity())
		                     .distinct()
		                     .forEach(System.out::println);
	}
	//3.查找所有来自剑桥的交易员，并按姓名排序
	@Test
	public void test3(){
		transactions.stream().filter((t)->t.getTrader().getCity().equals("Cambridge"))
		                     .map(Transaction::getTrader)
		                     .sorted((x,y)->x.getName().compareTo(y.getName()))
		                     .forEach(System.out::println);
	}
	//4.返回所有交易员的名字字符串，并按字母顺序排序
	@Test
	public void test4(){
		String str=transactions.stream().map((x)->x.getTrader().getName())
		                     .sorted((x,y)->x.compareTo(y))
		                     .reduce("",String::concat);
		      System.out.println(str);               
	}
	//5.有没有交易员是在米兰工作的？
	@Test
	public void test5(){
		Boolean b1=transactions.stream().anyMatch((x)->x.getTrader().getCity().equals("Milan"));
        System.out.println(b1);		            
	}
	//6.打印工作在剑桥的所有交易员的总交易额
	@Test
	public void test6(){
		Integer sum=transactions.stream().filter((t)->t.getTrader().getCity().equals("Cambridge"))
		                     .map(Transaction::getValue)
		                     .reduce(0,Integer::sum);
		System.out.println(sum);
	}
   //7.所有交易中，最高的交易额是多少
	@Test
	public void test7(){
		Optional<Integer> max = transactions.stream().map(Transaction::getValue).max(Integer::compare);
		System.out.println(max.get());
	}
	//8.找到交易额最少的交易
	@Test
	public void test8(){
		Optional<Transaction> min = transactions.stream().min((x,y)->Integer.compare(x.getValue(), y.getValue()));
		System.out.println(min.get());
	}
	

}