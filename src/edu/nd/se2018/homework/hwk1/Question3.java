package edu.nd.se2018.homework.hwk1;
public class Question3 {
	
	public Question3(){}	
	
    public int getMirrorCount(int[] numbers){
    	int count = 0;
    	boolean isMirror = false;
    	int length = numbers.length;
    	//loop through array checking for similar digits
    	for (int i = 0; i < length; i++) {
    		if (numbers[i] == numbers[length - 1 - i]) { //minus one to account for indexing
    			if (count == 0 || isMirror) {
    				count += 1;
    				isMirror = true;
    			}
    		}
    		else {
    			isMirror = false;
    		}
    	}
		return count;	
	}
}
