package com.rajan.crackingcoding.ch8;

public class Fibonacci_8_1{

	public Fibonacci_8_1(){
	
	}

	public int calculateFibonacciNum(int num){
		if(num==1){
			return 0;
		}else if(num==2){
			return 1;
		}
		return calculateFibonacciNum(num-1) + calculateFibonacciNum(num-2);
	}
	
	public int calculateFibonacciItr(int num){
		int arr[] = new int[num];
		arr[0] = 0;
		arr[1] = 1;
 		for(int i=2; i < num; i++){
			arr[i] = arr[i-1] + arr[i-2];
		}
 		return arr[num-1];
	}
	
	public static void main(String[] args){
		int num = 9;
		Fibonacci_8_1 fibo = new Fibonacci_8_1();
		System.out.println(num + "th Fibonacci Number (Rec) : " +  fibo.calculateFibonacciNum(num));
		System.out.println(num + "th Fibonacci Number (Itr) : " +  fibo.calculateFibonacciItr(num));
	}
}

// 0 1 1 2 3 5 8 13 21 34
