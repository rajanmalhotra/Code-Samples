package com.rajan.crackingcoding.ch3;

class stackNode{
	int data;
	int min;
	stackNode next;

	public stackNode(int val){
		data = val;
		min = 0;
		next = null;
	}
}

public class MinStack_3_2{
	private stackNode top;

	public MinStack_3_2(){
		top = null;	
	}

	public void push(int val){
		stackNode newNode = new stackNode(val);
		if(top!=null){
			if(top.min > newNode.data){
				newNode.min = newNode.data;			
			} else {
				newNode.min = top.min;
			}
			newNode.next = top;
			top = newNode;
		} else{
			newNode.min = newNode.data;
			top = newNode;
		}
	}

	public int pop(){
		if(top!=null){
			int val = top.data;
			top = top.next;
			return val;
		}
		return -1;
	}	
}


