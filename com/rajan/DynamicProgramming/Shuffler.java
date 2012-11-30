package com.rajan.DynamicProgramming;

public class Shuffler {
	
	public static boolean checkShuffle(String A, String B, String shuffle){
		int lenA = A.length();
		int lenB = B.length();
		int lenC = shuffle.length();
		if(lenA + lenB != lenC){
			return false;
		}
		
		boolean mix[][] = new boolean[lenA+1][lenB+1];
		for(int i=0; i <= lenA; i++){
			mix[i][0] = true; 
		}
		for(int j=0; j <= lenB; j++){
			mix[0][j] = true; 
		}

		for(int i=1; i <= lenA; i++){
			for(int j=1; j <= lenB; j++){
				mix[i][j] = 
							(mix[i][j-1] && B.charAt(j-1)==shuffle.charAt(i+j-1)) ||
							(mix[i-1][j] && A.charAt(i-1)==shuffle.charAt(i+j-1));
			}
		}
		
		for(int i=0; i <= lenA; i++){			
			for(int j=0; j <= lenB; j++){
				System.out.print(mix[i][j] + " ");
			}
			System.out.println();
		}
		return mix[lenA][lenB];
	}
	
	public static boolean checkInterLeaveR(String A, String B, String interLeaved){
		if(A.length()==0){
			if(B.equals(interLeaved)){
				return true;
			}
			return false;
		}
		if(B.length()==0){
			if(A.equals(interLeaved)){
				return true;
			}
			return false;
		}
		boolean success = false;
		if(A.charAt(0)==interLeaved.charAt(0)){
			success = checkInterLeaveR(A.substring(1), B, interLeaved.substring(1));
		}else if(B.charAt(0)==interLeaved.charAt(0)){
			success = checkInterLeaveR(A, B.substring(1), interLeaved.substring(1));
		}else{
			return false;
		}
		return success;
	}
	
	public static void main(String[] args){
		/*String A = "Dynamic";
		String B = "Programming";
		String interLeaved = "DyPnroagramimcming";*/
		String A = "chocolate";
		String B = "chips";
		String shuffle = "cchocohilaptes";
		System.out.println("Are \"" + A + "\" and \"" + B + 
				"\" interleaved : " + checkShuffle(A, B, shuffle));
		shuffle = "chocochilatspe";
		System.out.println("Are \"" + A + "\" and \"" + B + 
				"\" interleaved : " + checkShuffle(A, B, shuffle));
	}
}
