package edu.nd.se2018.homework.hwk1;

import java.util.HashSet;

public class Question1 {
		
	public Question1(){}
	
	public int getSumWithoutDuplicates(int[] numbers){
		HashSet<Integer> h = new HashSet<Integer>();
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
