package com.jevcodes.StreamExamples.StreamExamples;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMap {

	public static void main(String[] args) {


		//Create a stream using Stream of() function
		Stream.of("Michael Scott","Pam Beasley","Dwight Schrute","Jim Halpert")
			.map(x->x.substring(4)).forEach(x-> System.out.println(x));
		
		
		
		//Create a stream using Arrays.stream() and then store it in a List
		List<Integer> multiplesOfFive=( Arrays.stream(new Integer[]  
				{1,2,3,4,5}).map(x->(x*5)))
				//.forEach(x->System.out.println(x));	
				.collect(Collectors.toList());
		
		//Print List
		for (Integer i : multiplesOfFive)
			System.out.println(i);
	

		//Use Map 
	    Stream<String> capslock = Stream.of("Jevic","Jarret","D'Angelo","Caris","Spencer","Joe","Rodions");
	    		
	//    capslock.map(x->x.toUpperCase()).forEach(x->System.out.println(x));
	    capslock.map(String::toUpperCase).forEach(System.out::println);
	    
	    
	    Stream.Builder<Employee> employeesStream = Stream.builder();
	    employeesStream.accept(new Employee("Michael Scott", 30000000));
	    employeesStream.accept(new Employee("Jim Halpert", 60000));
	    employeesStream.accept(new Employee("Dwight Shrute", 90000));
	    employeesStream.accept(new Employee("Andy Bernard", 88000));
	    
	    employeesStream.build().filter(x -> x.getSalary()>86000).forEach(x->System.out.println(x.getName() 
	    		+ " earns more than 88,000 - making " + x.getSalary()));
	    
	    String s = "Mr. and Mrs. Dursley, of number four, Privet Drive, were proud to say\r\n" + 
	    		"that they were perfectly normal, thank you very much. They were the last\r\n" + 
	    		"people you'd expect to be involved in anything strange or mysterious,\r\n" + 
	    		"because they just didn't hold with such nonsense";
	    
	 //  Stream<String> stringStream = Stream.of(s).map(String::toUpperCase);
	   // stringStream.forEach(x -> System.out.println(x));
	   
	 // System.out.println(
	  //stringStream.filter(x->x.contains("number")).findFirst().orElse("nothing"));
	    
	 //   stringStream.forEach(x-> System.out.println("the string is consumed"));
	    
	  String[] abc = s.split(" ");
	/*  Arrays.stream(abc).filter(x->x.equalsIgnoreCase("number")
			  || x.contains("s")
			  ).map(String::toUpperCase).forEach(x->System.out.println(x));  */
	  
	  
	  Arrays.stream(abc).filter(x->x.equalsIgnoreCase("number")
			  || x.contains("s")
			  ).map(
					  new Function<String, String>() {

						@Override
						public String apply(String s) {
							// TODO Auto-generated method stub
						 return	s.toUpperCase();
						}
					}
					  ).forEach(x->System.out.println(x)); 
	
	   
	    
	    //File f = new File(pathname)
	    //FileReader fr = new FileReader(arg0)
	    /*
	    ArrayList<String> a = new ArrayList<>();
	    
	    a.add("first test");
	    
	    Listholder test = new Listholder();
	    
	    test.doWork(a);*/
	}

}

class Listholder{
	public void doWork(List<String> a) {
		a.add("test");
		a.stream().forEach(x->System.out.println(x));
	}
}
