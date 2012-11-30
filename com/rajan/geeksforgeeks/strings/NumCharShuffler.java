package com.rajan.geeksforgeeks.strings;

public class NumCharShuffler {
	
	public void swap(char[] arr, int a, int b){
		arr[a] = (char) (arr[a] ^ arr[b]);
		arr[b] = (char) (arr[a] ^ arr[b]);
		arr[a] = (char) (arr[a] ^ arr[b]);
	}
	
	public String shuffleNumChars(char[] arr){
		int len = arr.length;
		for(int range=1; range<len/2; range++){
			int start = len/2 - range;
			int end = len/2 + range;
			while(start < end){
				swap(arr, start, start+1);
				start = start+2;
			}
		}
		return new String(arr);
	}
	
	public static void main(String[] args){
		String s = "12345ABCDE";
		NumCharShuffler n = new NumCharShuffler();
		String ans = n.shuffleNumChars(s.toCharArray());
		System.out.println(s + " -> " + ans);
	}
}
