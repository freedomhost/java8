package day02.java8;

import java.util.Calendar;

import org.junit.Test;

public class Man {
   private Godness godness;

public Man() {
	super();
}

public Man(Godness godness) {
	super();
	this.godness = godness;
}

public Godness getGodness() {
	return godness;
}

public void setGodness(Godness godness) {
	this.godness = godness;
}
@Test
public void test10(){
	Calendar cal=Calendar.getInstance();
	cal.set(117, 10, 12);
	System.out.println(cal.DAY_OF_WEEK);
	System.out.println(cal.YEAR);
}
@Override
public String toString() {
	return "Man [godness=" + godness + "]";
}
 
}
