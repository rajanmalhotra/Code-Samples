package com.rajan.crackingcoding.ch4;

import com.rajan.crackingcoding.ch2.*;
import java.util.List;

public class DLinkedListsOfBST_4_4{

	public DLinkedListsOfBST_4_4(){
	}

	public static void main(String[] args){
		BST<Integer> bst = new BST<Integer>();
		int[] arr = {20, 30, 10, 8, 16, 24, 26, 48, 22};
		int level = 1;
		for(int i=0; i < arr.length; i++){
			bst.insert(arr[i]);		
		}
		List<LinkedList<Integer>> ll = bst.createLinkedLists();
		for(LinkedList<Integer> l : ll){
			System.out.println("List at : " + level++);
			l.print();			
		}
	}	
}
