package com.rajan.DynamicProgramming;

/*
 * Edit Distance. Given two text strings A of length n and B of length m, you want to transform A into B 
 * with a minimum number of operations of the following types: delete a character from A, insert a character 
 * into A, or change some character in A into a new character. The minimal number of such operations required 
 * to transform A into B is called the edit distance between A and B.
 * 
 * Similar to Longest Common Subsequence
 * Costs : Ci (insertion), Cd (deletion) and Cr (replacement). Find minimum cost to convert A -> B.
 * ED[i][j] = minimum cost to transform A[0...i] into B[0...j]
 */

public class EditDistance {
	
	public static int min(int a, int b, int c){
		return Math.min(Math.min(a,b),c);
	}
	
	public static int editDistance(char[] A, char[] B){
		
		int Ci=1; int Cd=1; int Cr=1;
		int ED[][] = new int[A.length+1][B.length+1];
		for(int i=0; i < ED.length; i++){
			ED[i][0] = i; 
		}
		for(int i=0; i < ED[0].length; i++){
			ED[0][i] = i; 
		}
		
		for(int i=1; i < ED.length; i++){
			for(int j=1; j < ED[0].length; j++){
				if(A[i-1]==B[j-1]){
					ED[i][j] = ED[i-1][j-1];		// Nothing to replace
				}else{
					ED[i][j] = 
							min(
								ED[i-1][j-1] + Cr,		// Replace last char of A
								ED[i-1][j] + Cd,	// delete last char of A
								ED[i][j-1] + Ci		// insert last char in B
							);
				}
			}
		}
		return ED[A.length][B.length];
	}
	
	public static void main(String[] args){
		String A = "Dynamic";
		String B = "Syndrome";
		System.out.println("Edit Distance between " + A + " and " +	B + " : "
							+ editDistance(A.toCharArray(), B.toCharArray()));
	}
}
