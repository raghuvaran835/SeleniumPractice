package com.practiceJavaStreams;

import java.util.ArrayList;

import com.google.common.annotations.VisibleForTesting;

public class JavaStreams_Test_Program {

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
	
}
