package com.JavaStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.cucumber.java.sl.In;


public class PracticeJavaStreams {

	@Test
	public void test_01()
	{
		ArrayList<String> a=new ArrayList<String>();
		a.add("Akshaya");
		a.add("Arun");
		a.add("Ajith");
		a.add("Raghu");
		a.add("Charan");
		
		int count=0;
		for(int i=0;i<a.size();i++)
		{
			if(a.get(i).startsWith("R"))
			{
				count +=1;
			}
		}
		
		System.out.println(count);
	}
	
	@Test
	public void streamFilter()

	{
		ArrayList<String> names=new ArrayList<String>();
		names.add("Lokesh");
		names.add("Arun");
		names.add("Ajith");
		names.add("Raghu");
		names.add("Charan");
		
//	count the names which starts with 'R' using streams
//		Three Steps:
//			1.Convert the arrayList to Java Streams
//			2.Apply the filter based on condition(works like a Lambda expression)-intermediate Operation
//			3.terminal operation.->There is no life for intermediate operation, if there is no terminal operation
		
		Long count=names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(count);
		
		
//	Print the names where name length is > 5
		System.out.println("Print the names which has the more than 5 chars:");
		names.stream().filter(n->n.length()>5).forEach(s->System.out.println(s));
		
//	Print only first result
		System.out.println("Limit the result to 1:");
		names.stream().filter(n->n.length()>5).limit(1).forEach(s->System.out.println(s));
		
		
	}
	
	@Test
	public void streamMap()
	{
		//Print the names which endswith "a" and return result with uppercase
		System.out.println("Print the names which endswith \"a\" and return result with uppercase:");
		Stream.of("Abhijeet","Don","Illakiya","Rama","Aish","Aarun").filter(n->n.endsWith("a")).map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		
		//Print the names which startsWith "A" and return result with uppercase and sorted order
		System.out.println("\nPrint the names which startsWith \"A\" and return result with uppercase and sorted order:");
		Stream.of("Aaron","Ankeet","Aish","Don","Illakiya","Rama").filter(n->n.startsWith("A")).map(s->s.toUpperCase()).sorted()
		.forEach(s->System.out.println(s));
		
		//Merging two lists and sort the result

		System.out.println("\nMerging two lists and sort :");
		List<String> names1=Arrays.asList("Raghuvaran","Charan","Lokesh","Ajay");
		List<String> names2=Arrays.asList("Barath","Swetha","Illakiya","Kayal");
		
		Stream newStream=Stream.concat(names1.stream(),names2.stream());
//		newStream.sorted().forEach(s->System.out.println(s));
		
		// Check if the name with adam is present in the stream
		System.out.println("Check if the string is present in the stream:");
		Boolean flag=newStream.anyMatch(s->((String) s).equalsIgnoreCase("illakiya"));
		Assert.assertTrue(flag);
		
	}
	
	@Test
	public void streamCollect()
	{
		//Collecting the result in a list and Sorting in Ascending Order
		System.out.println("Collecting the result in a list and Sorting in Ascending Order");
		List<String> ls=Stream.of("Arun","Ajay","Anandhi","Charan","Bala","Lokesh").filter(s->s.endsWith("n"))
				.map(s->s.toUpperCase()).sorted()
				.collect(Collectors.toList());
		System.out.println(ls.get(0));
		
		//Collecting the result in a list and Sorting in Descending Order
		System.out.println("Collecting the result in a list and Sorting in Descending Order");
		List<String> ls1=Stream.of("Arun","Ajay","Anandhi","Charan","Bala","Lokesh").filter(s->s.endsWith("n"))
				.map(s->s.toUpperCase()).sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		System.out.println(ls1.get(0));
		
		System.out.println("\nPrint the unique elements from the array:");
		List<Integer> values=Arrays.asList(3,2,2,5,1,9,7,3);
		
		values.stream().distinct().sorted().forEach(i->System.out.println(i));
		
		List<Integer> li=values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(li.get(2));
		
	}
}
