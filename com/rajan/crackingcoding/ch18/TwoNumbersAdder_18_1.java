package com.rajan.crackingcoding.ch18;

/* add two numbers without using + or any arithmetic operators */

public class TwoNumbersAdder_18_1 {

	public static int addtwonumbers(int a, int b){
		while(b>0){
			int carry = a & b;
			a = a ^ b;
			b = carry << 1;
		}
		return a;		
	}
	
	public static void main(String[] args){
		int a = 34;			// 100010
		int b = 43;			// 101011		
		System.out.println(addtwonumbers(a, b));
	}
}
