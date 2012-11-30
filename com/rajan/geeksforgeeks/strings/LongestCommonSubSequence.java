package com.rajan.geeksforgeeks.strings;

public class LongestCommonSubSequence {
	
	public static void longestCommonSubsequence(char[] str1, char[] str2){
	    int len1 = str1.length;
	    int len2 = str2.length;
	   
	    int lcs[][] = new int[len1+1][len2+1];
	    for(int i=0; i <=len2; i++){
	            lcs[0][i] = 0;

	    }
	    for(int i=0; i <=len1; i++){
	            lcs[i][0] = 0;

	    }
	   
	    for(int i=1; i <= len1; i++){
	        for(int j=1; j <= len2; j++){
	            if(str1[i-1]==str2[j-1]){
	                lcs[i][j] = lcs[i-1][j-1] + 1;
	            }else{
	            	lcs[i][j] = Math.max(lcs[i][j-1], lcs[i-1][j]);
	            }
	        }
	    }
	    System.out.println("Length of LCS : " + lcs[len1][len2]);
	}
	
	public static void main(String[] args){
		String a = "longer sequence";
		String b = "can i find longest common sequence?";
		longestCommonSubsequence(a.toCharArray(), b.toCharArray());
	}
}
