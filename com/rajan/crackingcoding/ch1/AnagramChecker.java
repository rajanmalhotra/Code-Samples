package com.rajan.crackingcoding.ch1;

import java.util.HashMap;

public class AnagramChecker{

	private String string;

	public String getString(){
		return string;	
	}
	
	public void setString(String str){
		string = str;	
	}
	
	public boolean isAnagram(String other){
		int len1 = string.length();
		int len2 = other.length();
		char str1[] = string.toCharArray();
		char str2[] = other.toCharArray();

		if(len1!=len2){
			return false;		
		}
	
		HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();
		for(int i=0; i < len1; i++){
			if(hashmap.containsKey(str1[i])){
				hashmap.put(str1[i], hashmap.get(str1[i])+1);			
			} else {
				hashmap.put(str1[i], 1);			
			}
		}
		
		boolean anagramFlag = true;
		for(int i=0; i < len2; i++){
			if(hashmap.containsKey(str2[i])){
				if(hashmap.get(str2[i])==0){
					anagramFlag	= false;
				}else {
					hashmap.put(str2[i], hashmap.get(str2[i])-1);			
				}
			} else {
				anagramFlag	= false;
			}
			if(!anagramFlag){
				break;			
			}
		}
		return anagramFlag;
	}

	public static void main(String[] args){
		AnagramChecker checker = new AnagramChecker();
		checker.setString("I AMLORD VOLDEMORT");
		String str = "TOM MARVOLO RIDDLE";
		if(checker.isAnagram(str)){
			System.out.println(checker.getString() + " : "  + str + " = are Anagrams");
		}else{
			System.out.println(checker.getString() + " : "  + str + " = are Not Anagrams");
		}
	}
}

/*
HashMap:
clear()
clone()
containsKey(Object key)
containsValue(Object value)
entrySet()
get(Object key)
isEmpty()
keySet()
put(Object key, Object value)
putAll(Map m)
remove(Object key)
size()
values()

==============================
containsKey(Object key)
containsValue(Object value)
get(Object key)
isEmpty()
put(Object key, Object value)
remove(Object key)
size()
==============================
*/

