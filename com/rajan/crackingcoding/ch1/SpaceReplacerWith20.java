package com.rajan.crackingcoding.ch1;

//import 

public class SpaceReplacerWith20{
	private String string;

	SpaceReplacerWith20(){
		string = "";
	}

	public String getString(){
		return string;	
	}
	
	public void setString(String str){
		string = str;	
	}

	public void replaceSpacewith20(){
		int len = string.length();
		StringBuilder str = new StringBuilder();
		
		for(int i=0; i < len; i++){
			if(string.charAt(i)==' '){
				str.append("%20");
			}else{
				str.append(string.charAt(i));
			}
		}
		string = str.toString();
	}

	public static void main(String[] args){
		SpaceReplacerWith20 sr = new SpaceReplacerWith20();
		sr.setString("Rajan is a good boy");
		sr.replaceSpacewith20();
		System.out.println(sr.getString());
	}
}
