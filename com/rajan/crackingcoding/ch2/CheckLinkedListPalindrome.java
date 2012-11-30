package com.rajan.crackingcoding.ch2;

public class CheckLinkedListPalindrome {
	
	public static Result checkPalindrome(Node<Integer> list, int length){
		if(length==0){
			return new Result(list, true);
		}else if(length==1){
			return new Result(list.next, true);
		}
		boolean resFlag = false;
		Node<Integer> nextNode=null;
		Result res = checkPalindrome(list.next, length-2);
		if(res!=null && res.value){
			if(res.node.data==list.data){
				nextNode = res.node.next;
				resFlag = true;
			}else{
				resFlag = false;
			}
		}else{
			resFlag = false;
		}
		return new Result(nextNode, resFlag);		
	}
	
	public static int findLength(Node<Integer> list){
		Node<Integer> temp = list;
		int count=0;
		while(temp!=null){
			temp = temp.next;
			count++;
		}
		return count;
	}
	public static void main(String[] args){
		LinkedList<Integer> list = new LinkedList<Integer>();
		int arr[] = {0, 2, 1, 4, 6, 6, 4, 1, 2, 0};
		for(int val:arr){
			list.append(val);
		}
		list.print();
		int len = findLength(list.head);
		if(checkPalindrome(list.head, len).value){
			System.out.println("LinkedList is a Palindrome");
		}else{
			System.out.println("LinkedList is not a Palindrome");
		}
	}
}

class Result{
	public Node<Integer> node;
	public boolean value;
	
	Result(Node<Integer> n, boolean val){
		node = n;
		value = val;
	}
}