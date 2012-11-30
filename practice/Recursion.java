package practice;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Arrays;

public class Recursion implements Comparator<String>{
	public List<List<Integer>> allSubSets(List<Integer> list, int index){
		List<List<Integer>> allSets;
		if(index==list.size()){
			List<Integer> set = new ArrayList<Integer>();
			allSets = new ArrayList<List<Integer>>();
			allSets.add(set);
			return allSets;
		}

		int item = list.get(index);
		allSets = allSubSets(list, index+1);
		List<List<Integer>> moreSets = new ArrayList<List<Integer>>();
		for(List<Integer> set : allSets){
			List<Integer> newSet = new ArrayList<Integer>();
			newSet.addAll(set);
			newSet.add(item);
			moreSets.add(newSet);
		}
		allSets.addAll(moreSets);
		return allSets;
	}

	public List<String> allPermutations(String str){
		List<String> allWords = new ArrayList<String>();
		if(str==null){
			return null;		
		}
		if(str.length()==0){
			allWords.add("");
			return allWords; 
		}
		char item = str.charAt(0);
		List<String> words = allPermutations(str.substring(1));
		for(String word : words){
			for(int i=0; i <= word.length(); i++){
				String newWord = insertCharAt(word, i, item);
				allWords.add(newWord);
			}
		}
		return allWords;
	}

	public String insertCharAt(String word, int pos, char item){
		String start = word.substring(0, pos);
		String end = word.substring(pos);
		return start + item + end;	
	}

	public int makeChange(int n, int denom){
		int ways = 0;
		int nextDenom = 0;
		switch(denom){
			case 25 : nextDenom = 10; break;
			case 10 : nextDenom = 5; break;	
			case 5 : nextDenom = 1; break;
			case 1 : return 1;
		}

		for(int i=0; i*denom <= n; i++){
			ways += makeChange(n-i*denom, nextDenom);
		}
		return ways;
	}

	int[] columnForRow = new int[8];
	public boolean check(int row){
		for(int i=0; i<row;i++){
			int diff = Math.abs(columnForRow[row]-columnForRow[i]);			
			if(diff == 0 || diff==row-i){
				return false;
			}
		}
		return true;
	}

	public String sortChars(String s){
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}

	public int compare(String s1, String s2){
		if(s1.length()==s2.length()){
			return sortChars(s1).compareTo(sortChars(s2));		
		}else{
			return s1.compareTo(s2);		
		}
	}

	public void placeQueen(int row){
		if(row==8){
			//printBoard();		
			return;
		}
		for(int i=0; i < 8;i++){
			columnForRow[row] = i;
			if(check(row)){
				placeQueen(row+1);			
			}		
		}
	}

	public static void main(String[] args){
		List<Integer> list = new ArrayList<Integer>();
		int[] arr = {1, 2, 3, 4, 5};
		for(int val: arr){
			list.add(val);		
		}

		Recursion rec = new Recursion();
		List<List<Integer>> allSets = rec.allSubSets(list, 0);
		for(List<Integer> set : allSets){
			for(int val : set){
				System.out.print(val+" ");			
			}		
			System.out.println();
		}

		List<String> words = rec.allPermutations("Ankur");
		for(String word : words){
			System.out.println(word);
		}

		System.out.println("Ways to make Change : " + rec.makeChange(50,25));

		String[] strs = {"rajna", "janra", "janar", "aajnr", "ankur", "and", "dan", "nda", "nad", "rajan"};
		Arrays.sort(strs, new Recursion());
		for(String str:strs){
			System.out.println(str);		
		}
	}
}
