package com.rajan.geeksforgeeks.stacks;

import com.rajan.geeksforgeeks.stacks.Stack;

public class ReverseStack {

	public static Stack<Integer> s;
	
	public static void swap(){
		try{
			int item1 = s.pop();
			int item2 = s.pop();
			s.push(item1);
			s.push(item2);
		}catch(Exception ex){
			System.out.println("Exception");
		}
 	}
	
	public static void reverseR(int level){
		if(level==0){
			return;
		}
		swap();
		try{
			int item = s.pop();
			reverseR(level-1);
			s.push(item);
		}catch(Exception ex){
			System.out.println("Exception");
		}
	}
	
	public static void reverse(int level){
		if(level==0){
			return;
		}
		reverseR(level);
		reverse(level-1);
		// Same technique for running above code 
		/*for(int i=level; i > 0; i--){
			reverseR(i);
		}*/
	}
	
	public static void main(String[] args){
		s = new Stack<Integer>();
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
		for(int i=0; i < arr.length; i++){
			s.push(arr[i]);
		}	
		reverse(arr.length-1);
		for(int i=0; i < arr.length; i++){
			try{
				System.out.println(s.pop());
			}catch(Exception ex){
				
			}
		}
	}
}
