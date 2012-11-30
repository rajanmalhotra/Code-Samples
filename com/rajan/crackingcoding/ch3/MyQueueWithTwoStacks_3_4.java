package com.rajan.crackingcoding.ch3;

/*
 * Implement a MyQueue class which implements a queue using two stacks 
 */

public class MyQueueWithTwoStacks_3_4 {
	private Stack<Integer> s1;
	private Stack<Integer> s2;
	
	public MyQueueWithTwoStacks_3_4(){
		s1 = new Stack<Integer>();
		s2 = new Stack<Integer>();
	}

	public int size(){
		return s1.size() + s2.size();
	}

	public boolean isEmpty(){
		if(size()==0){
			return true;
		}
		return false;
	}

	public void add(int val){
		s1.push(val);
	}

	public int remove(){
		int val=-1;
		try{
			if(s2.isEmpty()){
				while(!s1.isEmpty()){
					s2.push(s1.pop());
				}
			}
			val = s2.pop();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}	
		return val;
	}

	public int peek(){
		int val=-1;
		try{
			if(s2.isEmpty()){
				while(!s1.isEmpty()){
					s2.push(s1.pop());
				}
			}
			val = s2.peek();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return val;
	}

	public static void main(String[] args){
		MyQueueWithTwoStacks_3_4 queue = new MyQueueWithTwoStacks_3_4();
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
		for(int val:arr){
			queue.add(val);
		}
		System.out.println("Printing the values when removed from queue");
		while(!queue.isEmpty()){
			System.out.println(queue.remove());
		}		
	}
}
