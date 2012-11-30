package com.rajan.crackingcoding.ch1;

//import

public class RemoveDuplicates{
	
	private String string;

	RemoveDuplicates(){
		string = "";
	}
	
	public String getString(){
		return string;
	}
	
	public void setString(String str){
		string = str;
	}

	public void removeDuplicates(){
		int len = string.length();
		int end = 1;
		boolean uniqueFlag;
		char temp[] = string.toCharArray();
		for(int i=1; i < len; i++){
			uniqueFlag = true;
			for(int j=0; j < end; j++){
				if(temp[i] == temp[j]){	
					uniqueFlag = false;
					break;				
				}			
			}
			if(uniqueFlag){
				temp[end++] = temp[i];
			}
		}
		string = new String(temp, 0, end);		
	}
	
	public static void main(String[] args){
		RemoveDuplicates rd = new RemoveDuplicates();
		rd.setString("Removing the duplicates");
		System.out.print(rd.getString() + " : ");
		rd.removeDuplicates();
		System.out.print(rd.getString() + "\n");
	}
}
