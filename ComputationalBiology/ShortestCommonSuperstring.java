package ComputationalBiology;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class ShortestCommonSuperstring {
	
	private void createSuperString(Set<String> subStrings) {
		int totalStrings = subStrings.size();
		String[] match = new String[totalStrings];
		int i = 0;	
		
		for(String superString : subStrings) {					
			
			Set<String> temp = new HashSet<String>(subStrings);
			String maxSuperString = superString;
			while(temp.size() > 1) {
				
				String subString = "";
				String nextMaxSuperString = maxSuperString;

				for(String nextString : temp) {
									
					if(!nextString.equals(nextMaxSuperString)) {
					
						String superTemp = getSuperString(maxSuperString, nextString);
						if (nextMaxSuperString.equals(maxSuperString) || nextMaxSuperString.length() > superTemp.length()) {
							nextMaxSuperString = superTemp;
							subString = nextString;	
						}							
					}					
				}
				
				temp.remove(maxSuperString);
				temp.remove(subString);
				maxSuperString = nextMaxSuperString;
				temp.add(maxSuperString);
			}
			
			match[i] = maxSuperString; 
			System.out.println(match[i]);
			i++;
		}
		
		String bestAns = match[0];
		
		for(i = 1; i < match.length; i++) {
			if(bestAns.length() > match[i].length()) {
				bestAns = match[i];
			}
		}
		
		System.out.println("Shortest Common Super String => " + bestAns);
		System.out.println("With a Length of             => " + bestAns.length());
			
	}
	
	private String getSuperString(String superString, String someString) {
		String result = superString;
		
		int endIndex = someString.length() - 1;
		
		while(endIndex > 0 && !superString.endsWith(someString.substring(0, endIndex)))	{
			endIndex--;
		}
		
		
		if(endIndex > 0) {
			result += someString.substring(endIndex);
		}
		else {
			result += someString;
		}
		
		return result;
	}
	
	public Set<String> createRandomFragments(String input,
								int noOfFragments, int lenOfFragments){
		
		/* variables for random indices calculation */
		int len = input.length();
		int rand = len - lenOfFragments + 1;
		Set<String> fragments = new HashSet<String>();
		Set<Integer> used = new HashSet<Integer>();
		int randIndex = 0;
		boolean repeatsAllowed = false;
		
		/* require repeats if noOfFragments are way too many */
		if(rand < noOfFragments){
			repeatsAllowed = true;
		}
		
		/* 
		 * create m random fragments of length l from the input string 
		 * find only those fragments whose index is between 0 and (len - lenOfFragments)  
		 */
		while(noOfFragments > 0){
			while(true){
				randIndex = (int)(Math.random()*rand);
				
				/* check if repeats are allowed or not */
				if(repeatsAllowed || !used.contains(randIndex)){
					used.add(randIndex);
					if(lenOfFragments + randIndex <= len){
						fragments.add(input.substring(randIndex, lenOfFragments + randIndex));
						//System.out.println(input.substring(randIndex, lenOfFragments + randIndex));
					}
					noOfFragments--;
					break;
				}else{
					continue;
				}
			}
		}
		return fragments;
	}
	
	public static void main(String arg[]) {
		
		Set<String> fragments = new HashSet<String>();
		ShortestCommonSuperstring superStringCreator = new ShortestCommonSuperstring();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		int noOfFragments = 0;		/* noOfFragments = m */
		int lenOfFragments = 0;		/* lenOfFragments = l */
		
		/* read input string, no. of fragments and their length */
		try{
			System.out.println("Enter the string : ");
			input = br.readLine();
			System.out.println("Enter the no of Fragments : ");
			noOfFragments = Integer.parseInt(br.readLine());
			System.out.println("Enter the length of each fragment : ");
			lenOfFragments = Integer.parseInt(br.readLine());			
		}catch(Exception ex){
			System.out.println("Please give correct Inputs.");
			ex.printStackTrace();
			return;
		}
		
		/* create fragments of the input string */
		fragments = superStringCreator.createRandomFragments(input, noOfFragments, lenOfFragments);
			
		/* find the shortest super string */
		superStringCreator.createSuperString(fragments);
	}	
}

