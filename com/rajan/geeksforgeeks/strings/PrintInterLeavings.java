package com.rajan.geeksforgeeks.strings;

public class PrintInterLeavings {

	public void printIlsRec(String str1, String str2, char[] res, int i, int j, int k){
		if(i==str1.length() && j==str2.length()){
			System.out.println(new String(res));
			return;
		}
		if(i < str1.length()){
			res[k] = str1.charAt(i);
			printIlsRec(str1, str2, res, i+1, j, k+1);
		}
		if( j < str2.length()){
			res[k] = str2.charAt(j);
			printIlsRec(str1, str2, res, i, j+1, k+1);
		}		
	}
	
	public void printIls(String str1, String str2){
		char[] res = new char[str1.length() + str2.length()];
		int i, j, k;
		i=j=k=0;
		printIlsRec(str1, str2, res, i, j, k);
	}
	
	public static void main(String[] args){
		String str1 = "RA";
		String str2 = "MC";
		PrintInterLeavings p = new PrintInterLeavings();
		p.printIls(str1, str2);
	}
}
