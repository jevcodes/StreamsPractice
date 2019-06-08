package com.jevcodes.StreamExamples.StreamExamples;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFilter {

	public static void main (String[] args) {
		
		// Build Stream using Stream Builder. 
	    Stream.Builder<Employee> employeesStream = Stream.builder();
	    employeesStream.accept(new Employee("Michael Scott", 115000));
	    employeesStream.accept(new Employee("Jim Halpert", 60000));
	    employeesStream.accept(new Employee("Dwight Shrute", 90000));
	    employeesStream.accept(new Employee("Andy Bernard", 88000));
	    employeesStream.accept(new Employee("David Wallace", 750000));
	    employeesStream.accept(new Employee("Stanley Hudson", 89000));
	    employeesStream.accept(new Employee("Jan Levinson", 750000));
	    employeesStream.accept(new Employee("Ryan Howard", 25000));
	    employeesStream.accept(new Employee("Robert California", 1000000));
	   
	    //Filter for employees making more than 86,000 store to a list
	   List<Employee> employees=  employeesStream.build().filter(x -> x.getSalary()>86000).collect(Collectors.toList());
	    
	   System.out.println("below are all of the employees making more than 86k\n");
	   
	   //sort by name
	   employees.stream().sorted((a,b)->a.getName().compareTo(b.getName())).forEach(x->System.out.println(x.getName()));
	    
	   
	   System.out.println("\nbelow are the top 3 highest paid\n");
	   //sort by salary and return the top 3 highest paid
	   employees.stream().sorted((a,b)-> {
		   if (a.getSalary()<b.getSalary())
				   return 1;
				   else return -1;
			   
			   }).limit(3).forEach(x->System.out.println(x.getName()));
	   
	   System.out.println("\nbelow are the next top 3 highest paid\n");
	   
	   //sort by salary and then return the next 3 highest paid employees
	   employees.stream().sorted((a,b)-> {
		   if (a.getSalary()<b.getSalary())
				   return 1;
				   else return -1;
			   
			   }).skip(3).limit(3).forEach(x->System.out.println(x.getName()));
	   
	     
	   employees.stream().sorted((a,b)-> {
		   if (a.getSalary()<b.getSalary())
				   return 1;
				   else return -1;
			   
			   }).findFirst().ifPresent(x->System.out.println("The highest paid employee is \n" +x.getName()));//findFirst(x->System.out.println(x.getName()));
		
	}
	
}
