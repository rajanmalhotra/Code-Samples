package com.rajan.crackingcoding.ch9;

import java.util.Arrays;
import java.util.Comparator;

public class SortWithAnagrams_9_2 implements Comparator<String>{
	public int compare(String str1, String str2){
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		Arrays.sort(arr1);
		Arrays.sort(arr2);		
		return (new String(arr1)).compareTo(new String(arr2));
	}
	
	public static void main(String[] args){
		SortWithAnagrams_9_2 sa = new SortWithAnagrams_9_2();
		String[] arr = {"SPIN", "PINS", "TATOO", "BAIT", "MATE", "SNIP", "ZOO", "NSIP", "SPOW"};
		Arrays.sort(arr, sa);
		for(String s : arr){
			System.out.println(s);
		}
	}

}
