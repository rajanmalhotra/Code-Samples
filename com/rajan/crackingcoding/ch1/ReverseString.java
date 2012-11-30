package com.rajan.crackingcoding.ch1;

// import 

public class ReverseString{
	private String string;

	ReverseString(){
		string = "";
	}
	
	public String getString(){
		return string;
	}
	
	public void setString(String str){
		string = str;
	}
	
	public void reverseString(){
		int len = string.length();
		char temp[] = string.toCharArray();
		String rev = "";
		for(int i=0; i < len; i++){
			rev = rev + temp[len-i-1];
		}
		string = rev;
	}

	public static void main(String[] args){
		ReverseString rs = new ReverseString();
		rs.setString("Read this String reversed");
		rs.reverseString();
		System.out.println(rs.getString());
	}
}

