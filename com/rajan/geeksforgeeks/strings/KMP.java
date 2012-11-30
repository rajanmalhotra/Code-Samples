package com.rajan.geeksforgeeks.strings;

public class KMP {

	public int[] createLps(String pattern){
		int i = 2;
		int len = 0;
		int T[] = new int[pattern.length()];
		T[0] = -1;
		T[1] = 0;
		
		while(i < pattern.length()){
			if(pattern.charAt(i-1)==pattern.charAt(len)){
				len++;
				T[i]=len;
				i++;
			}else{
				if(len>0){
					len = 0;//T[len];
				}else{
					T[i] = 0;
					i++;
				}
			}
		}
		return T;		
	}
	
	public void KMPSearch(String text, String pat){
		int patLen = pat.length();
		int textLen = text.length();
		int i=0;
		int m=0;
		int T[] = createLps(pat);
		for(int k=0; k<T.length; k++){
			System.out.print(T[k] + " ");
		}
		System.out.println();
		
		while(m+i < textLen)
	    {
			if(pat.charAt(i) == text.charAt(m+i)){
				if(i==patLen-1){
					System.out.println("Found pattern at index : " + m + "\n");
					m = m + i -T[i];
				}else{
					i++;
				}
		    }else{
		    	m = m + i - T[i];
		    	if(T[i] > -1){
		    		i = T[i];
		    	}else{
		    		i = 0;
		    	}
		    }	 
	    }
	}
	
	public static void main(String[] args){
		String text = "just a sample text just for fun to justify the justification justfully";
		String pattern = "just"; 
		KMP k = new KMP();
		k.KMPSearch(text, pattern);
	}
}
