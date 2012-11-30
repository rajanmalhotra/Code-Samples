package practice;

import java.util.HashMap;

class AnagramsChecker{
	public static void main(String[] args){
		String str1 = "iam lord voldemort";
		String str2 = "tom marvolo riddlq";
		HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
		if(str1.length()!=str2.length()){
			System.out.println("Not Anagrams");
		}

		for(int i=0; i < str1.length(); i++){
			if(charMap.containsKey(str1.charAt(i)))	{
				charMap.put(str1.charAt(i), charMap.get(str1.charAt(i))+1);			
			}else{
				charMap.put(str1.charAt(i), 1);
			}
		}

		for(int i=0; i < str2.length(); i++){
			if(charMap.containsKey(str2.charAt(i)))	{
				int val = charMap.get(str2.charAt(i));
				System.out.println(val);
				if(val > 0){
					charMap.put(str2.charAt(i), val-1);
				}else{
					System.out.println("Not Anagrams");
					return;
				}
			}
			else{
				System.out.println("Not Anagrams");
				return;
			}
		}
		System.out.println("Anagrams");
	}
}

/*
Null Checks / Initializations
Increments of counters
Return values
*/
