package com.rajan.crackingcoding.ch3;

//import

public class ArrayAs3Stacks_3_1{
	
	private int stackSize = 100;
	private int[] array = new int[stackSize*3];
	private int[] stackPointer = {0, 0, 0};

	public ArrayAs3Stacks_3_1(){	
	}

	public void push(int stackNum, int value){
		int stackTop = stackNum * stackSize + stackPointer[stackNum-1] + 1;
		array[stackTop] = value;
		stackPointer[stackNum-1]++;
	}

	public int pop(int stackNum){
		int stackTop = stackNum * stackSize + stackPointer[stackNum-1];
		stackPointer[stackNum-1]--;
		int value = array[stackTop];
		array[stackTop] = 0;
		return value;
	}

	public int peek(int stackNum){
		int stackTop = stackNum * stackSize + stackPointer[stackNum-1];
		return array[stackTop];
	}

	boolean isEmpty(int stackNum){
		return stackPointer[stackNum-1] == stackNum * stackSize;
	}
}
