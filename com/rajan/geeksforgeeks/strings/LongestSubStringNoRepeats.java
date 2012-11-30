package com.rajan.geeksforgeeks.strings;

/*
 * Length of the longest substring without repeating characters
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substrings without repeating characters for “ABDEFGABEF” are “BDEFGA” and 
 * “DEFGAB”, with length 6. For “BBBB” the longest substring is “B”, with length 1. 
 */

public class LongestSubStringNoRepeats {
	
	public int lenLongestSubStringwithoutrepeats(String str, maxIndex index){
		int[] chars = new int[256];
		int currentLen=0;
		int maxLen = 0;
		int prev_index = 0;

		for(int i=0; i < chars.length; i++){
			chars[i] = -1;
		}

		chars[str.charAt(0)] = 0;
		for(int i=1; i < str.length(); i++){
			prev_index = chars[str.charAt(i)];			
			if(prev_index==-1 || i-prev_index > currentLen){
				currentLen++;
			}else{
				if(currentLen > maxLen){
					maxLen = currentLen;
					index.val = i - maxLen + 1;
				}
				currentLen = i - prev_index;
			}
			chars[str.charAt(i)] = i;
		}
		if(currentLen > maxLen){
			maxLen = currentLen;				
		}
		return maxLen;		
	}
	
	public static void main(String[] args){
		LongestSubStringNoRepeats ls = new LongestSubStringNoRepeats();
		String str = "Ankurkobhooklagi";//"GeeksForGeeks";
		maxIndex index = new maxIndex();
		int len = ls.lenLongestSubStringwithoutrepeats(str, index);
		System.out.println("The Longest SubString with no repeated chars is : "
							+ str.substring(index.val, index.val + len) + " of length " + len);
	}
}

class maxIndex{
	public int val;
}
