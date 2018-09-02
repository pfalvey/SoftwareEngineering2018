package edu.nd.se2018.homework.hwk1;

import java.util.HashSet;
import java.util.Set;

public class Question1 {
		
	public Question1(){}
	
	public int getSumWithoutDuplicates(int[] numbers){
		Set<Integer> h = new HashSet<Integer>();
		for (int x : numbers) {
			h.add(x);
		}
		int sum = 0;
		for (Integer x: h) {
			sum += x;
		}
		return sum;	
	}
}
