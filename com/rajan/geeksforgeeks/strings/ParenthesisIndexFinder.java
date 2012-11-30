package com.rajan.geeksforgeeks.strings;

import java.util.Stack;

public class ParenthesisIndexFinder {

	public static void findParenthesisIndex(String str){
		Stack<Integer> s = new Stack<Integer>();
		int len = str.length();
		int i=0;
		System.out.println("The first approach : ");
		while(i < len){
			char letter = str.charAt(i);
			if(letter=='('){
				s.push(i);
			}else if(letter==')'){
				int item = s.pop();
				System.out.println(item + " : " + i);
			}
			i++;	
		}
	}
	
	public static void findParenthesisIndexWithoutStack(String str){
		int len = str.length();
		int i = 0;
		int j = len-1;
		System.out.println("The second approach : ");
		while(i<j){
			char front = str.charAt(i);
			char end = str.charAt(j);
			while(front!='('){
				i++;
				front = str.charAt(i);
			}
			while(end!=')'){
				j--;
				end = str.charAt(j);
			}
			if(i<j){
				System.out.println(i + " : " + j);
				i++;
				j--;
			}
		}
	}
	
	public static void main(String[] args){
		String str = "(ra(jan((ma(()lho)t)r)a))";
		findParenthesisIndex(str);
		findParenthesisIndexWithoutStack(str);
	}
}
