package edu.nd.se2018.homework.hwk1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Question2 {

	public Question2(){}
	
	public String getMostFrequentWord(String input, String stopwords){
		Map<String, Integer> h = new HashMap<String, Integer>();
		//split strings into arrays
		List<String> words = new ArrayList<>(Arrays.asList(input.split(" ")));
		Set<String> stopWords = new HashSet<>(Arrays.asList(stopwords.split(" ")));
		words.removeAll(stopWords);
		
		
		//populate hashmap
		for (String s : words) {
			if (h.containsKey(s)) {
				h.put(s, h.get(s) + 1);
			}
			else {
				h.put(s, 1);
			}
		}
		
		//find most repeated word
		int count = 0;
		String repeatedWord = null;
		for (Map.Entry<String, Integer> x: h.entrySet()) {
			if (x.getValue() > count) {
				repeatedWord = x.getKey();
				count = x.getValue();
			}
			else if(x.getValue() == count) {
				repeatedWord = null;
			}
		}
		
		return repeatedWord;
	}
}
