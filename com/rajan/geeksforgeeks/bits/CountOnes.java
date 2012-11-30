package com.rajan.geeksforgeeks.bits;

public class CountOnes {

	public static int countOnes1(int num){
	    int count = 0;
	    while(num!=0){
	        if((num & 0x01) > 0){
	            count++;
	        }
	        num = num >> 1;
	}
	    return count;
	}

	public static int countOnes2(int num){
        int count = 0;
        while(num!=0){
            num = num & (num-1);
            count++;
        }
        return count;
	}
	
	public static void main(String[] args){
		System.out.println(countOnes1(64));
		System.out.println(countOnes2(32));
		
	}
}