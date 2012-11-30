package com.rajan.DynamicProgramming;

public class ConvertStringtoPalindrome {

	public String createPalindrome(String str){
		int len = str.length();
		int Val[][] = new int[len][len];
		
		for(int i=0; i<len; i++){
			Val[i][i] = 0;
		}
		
		for(int k=1; k<len; k++){
			for(int i=0; i<len-k; i++){
				int j = i+k;
				if(str.charAt(i)==str.charAt(j)){
					Val[i][j] = Val[i+1][j-1];
				}else{
					Val[i][j] = Math.min(Val[i][j-1], Val[i+1][j]) + 1;
				}					
			}
		}
		
		for(int i=0; i <len; i++){
			for(int j=0; j <len; j++){
				System.out.print(Val[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("Edits required : " + Val[0][len-1]);
		
		int i = 0;
		int j = len-1;
		String output = "";
		boolean isDone = false;
		/*for(int i=0; i < len; i++){
			for(int j=len-1; j>=0; j--){
				if(Val[i][j]==0){
					isDone = true;
				}
				output = output + 
			}
		}*/
		int p = 0;
		int q = 0;
				
		output = str;
		/*while( i < len && j>i){
			if(Val[i][j]==0){
				break;
			}
			if(Val[i][j]==(Val[i+1][j-1]+2)){
				StringBuffer temp = new StringBuffer(str.substring(i, j+1));
				temp = temp.insert(p+1, str.charAt(j));
				p++;
				temp = temp.append(str.charAt(i));
				p++;
				q--;
				i++;
				j--;
				output = str.charAt(p) + temp.toString() + str.charAt(q);
			}else if(Val[i+1][j] < Val[i][j]){
				String temp = str.substring(i+1, j);
				temp = temp + str.charAt(i);
				output.append(temp);
				i++;
			}else if(Val[i][j-1] < Val[i][j]){
				output.append(str.charAt(j));
				j--;
			}
		}*/		
		
		/*while(i < j){
			if(Val[i][j] == Val[i+1][j-1]){
				output += str.charAt(i);
				i++;
				j--;
			}else if(Val[i][j] == Val[i+1][j]){
				output += str.charAt(i);
				i++;
			}else{
				output = str.charAt(j) + output;
				j--;
			}
		}*/
		System.out.println("Palindrome after Edit : " + output);
		return null;
	}
	
	public static void main(String[] args){
		ConvertStringtoPalindrome csp = new ConvertStringtoPalindrome();
		String arr[] = {"ramar", "abc", "aab", "ankur", "rajan"};
		for(String str : arr){
			System.out.println("String : " + str);
			csp.createPalindrome(str);
		}
	}
}
