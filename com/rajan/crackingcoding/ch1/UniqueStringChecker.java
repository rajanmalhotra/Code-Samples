package com.rajan.crackingcoding.ch1;

// import

class UniqueString1{
	
	private String message;

	UniqueString1(){
		this.message = "";
	}

	public String getMessage(){
		return this.message;
	}
	
	public void setMessage(String message){
		this.message = message;
	}

	public boolean isUnique(){
		int i=0, j=1;
		for(i=1; i < message.length(); i++){
			for(j=0; j < i; j++){
				if(message.charAt(j) == message.charAt(i)){
					return false;
				}
			}
		}
		return true;
	}
}

public class UniqueStringChecker{
	public static void main(String[] args){
		UniqueString1 unique = new UniqueString1();
		unique.setMessage("Rajn Mlhotr");
		if(unique.isUnique())
			System.out.println(unique.getMessage() + " is Unique");
		else
			System.out.println(unique.getMessage() + " is not Unique");	
	}
}

