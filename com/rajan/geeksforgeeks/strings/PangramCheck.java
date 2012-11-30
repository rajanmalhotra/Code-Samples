package com.rajan.geeksforgeeks.strings;

public class PangramCheck {
	
	public static void getMissingLetters(String str){
		int val = 0;
		for(int i=0; i < str.length(); i++){
			char letter = str.charAt(i);
			if(letter >= 97){
				letter -= 32;
			}
			letter -= 65;
			val = val | (1 << letter); 
		}
		
		for(int i=0; i <=25; i++){
			if(((val >> i) & 1)==0){
				char letter = (char)(i+65);
				System.out.print(letter + " ");
			}
		}
	}
	
	public static void main(String[] args){
		String str = "A quick brown foz jumps over the dog lazy";
		getMissingLetters(str);
	}
}