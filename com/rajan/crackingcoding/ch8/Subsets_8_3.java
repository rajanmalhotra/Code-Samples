package com.rajan.crackingcoding.ch8;

import java.util.ArrayList;

public class Subsets_8_3{

	public Subsets_8_3(){
	}

	public ArrayList<ArrayList<Integer>> findSubSets(int[] arr, int pos){
		ArrayList<ArrayList<Integer>> allLists;
		if(pos==arr.length){
			allLists = new ArrayList<ArrayList<Integer>>();
			allLists.add(new ArrayList<Integer>());
		}
		else{
			allLists = findSubSets(arr, pos+1);
			//int item = arr[pos];
			ArrayList<ArrayList<Integer>> moreLists = new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> iter : allLists){
				ArrayList<Integer> newList = new ArrayList<Integer>();
				newList.addAll(iter);
				newList.add(arr[pos]);
				moreLists.add(newList);
			}
			allLists.addAll(moreLists);			
		}
		return allLists;
	}

	public static void main(String[] args){
		int total = 1;
		Subsets_8_3 sets = new Subsets_8_3();
		int[] arr = {1, 2, 3, 4, 5};
		ArrayList<ArrayList<Integer>> lists = sets.findSubSets(arr, 0);
		for(ArrayList<Integer> list : lists){
			System.out.print("List Number " + total++ + " : ");
			for(int i=0; i < list.size();i++){
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}
	}
}

