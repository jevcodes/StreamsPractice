package com.jevcodes.StreamExamples.StreamExamples;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMap {

	public static void main(String[] args) {


		//initialize employees
		
		
		
		List<Integer> multiplesOfFive=( Arrays.stream(new Integer[]  
				{1,2,3,4,5}).map(x->(x*5)))
				//.forEach(x->System.out.println(x));	
				.collect(Collectors.toList());
		for (Integer i : multiplesOfFive)
			System.out.println(i);
	

	    Stream<String> capslock = Stream.of("Jevic","Jarret","D'Angelo","Caris","Spencer","Joe","Rodions");
	    		
	//    capslock.map(x->x.toUpperCase()).forEach(x->System.out.println(x));
	    capslock.map(String::toUpperCase).forEach(System.out::println);
	    
	    
	    
	    
	}

}
