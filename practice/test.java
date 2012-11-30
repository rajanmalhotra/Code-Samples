package practice;

//import java.util.*;

public class test {
	public static void main(String[] args){	
		System.out.println(checkPalindrome("bitinitib"));
	}
	
	static boolean checkPalindrome(String str){
	    int end = str.length()-1;
	    if(end==0){
	    	return true;
	    }
	    if(str.charAt(0)==str.charAt(end)){
	        return checkPalindrome(str.substring(1, end));
	    }else{
	    	return false;
	    }
	}
}