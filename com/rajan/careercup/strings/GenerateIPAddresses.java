package com.rajan.careercup.strings;

import java.util.ArrayList;

/*
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * For example:
 * 		Given "25525511135",
 * 		return ["255.255.11.135", "255.255.111.35"]
 * 		{hint:recursion,backtrack}
 */

public class GenerateIPAddresses {

	private static ArrayList<String> generateIPs(String ip, int dots){
		ArrayList<String> list = new ArrayList<String>();
 		if(dots == 0){
			if(!ip.equals("")){
				return null;
			}else{
				list.add("");
				return list;
			}		
		}
 		
 		int num=0;
 		for(int i=1; i<=3; i++){
 			if(ip.length()>=i){
	 			String s = ip.substring(0, i);
	 			ArrayList<String> parts = generateIPs(ip.substring(i), dots-1);
	 			try{
	 				num = Integer.parseInt(s);
	 				if(num <= 255){
	 					if(parts!=null){
		 					for(String part : parts){
		 						if(dots==1){
		 							list.add(s);
		 						}else{
		 							list.add(s + "." + part);
		 						}
		 					}
	 					}
	 				}else{
	 					continue;
	 				}
	 			}catch(NumberFormatException ex){
	 				System.out.println("Invalid String");
	 				return null;
	 			}
 			}
 		}
		return list;
	}
	
	public static ArrayList<String> generateIPs(String ip){
		return generateIPs(ip, 4);
	}
	
	public static void main(String[] args){
		String ip = "25525511135";
		ArrayList<String> list = generateIPs(ip);
		for(String s : list){
			System.out.println(s);
		}
	}
}
