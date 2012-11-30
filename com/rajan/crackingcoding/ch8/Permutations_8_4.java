package com.rajan.crackingcoding.ch8;

import java.util.ArrayList;

public class Permutations_8_4{
	
	public Permutations_8_4(){
	}

	public ArrayList<String> getPermutations(String str){
		ArrayList<String> allPermutations = new ArrayList<String>();
		if(str == null){
			return null;
		}else if(str.length()==0){
			allPermutations.add("");
			return allPermutations;
		}
		char val = str.charAt(0);
		ArrayList<String> morePermutations = getPermutations(str.substring(1));			 
		for(String s : morePermutations){
			for(int i=0; i <= s.length(); i++){
				allPermutations.add(insertCharAt(s, val, i));
			}
		}
		return allPermutations;
	}

	private String insertCharAt(String str, char val, int i){
		String begin = str.substring(0, i);
		String end = str.substring(i);
		return begin + val + end;
	}

	public static void main(String[] args){
		int num = 1;
		Permutations_8_4 perms = new Permutations_8_4();
		String str = "WORK";
		ArrayList<String> list = perms.getPermutations(str);
		for(String s : list){
			System.out.println(num++ + " : " + s);
		}		
	}
}
