package companies.Amazon;

import java.io.*;
import java.util.StringTokenizer;

public class LevelOrderDeSerializer {
	
	public void deSerializeLevelOrder(){
		
	}
	
	public static void main(String[] args){
		try{
			BufferedReader input =  new BufferedReader(new FileReader(new File("/home/rajan/Work_MS/Code-Samples/companies/Amazon/text")));
			String s = null;
			while((s = input.readLine())!=null){
				StringTokenizer tokenizer = new StringTokenizer(s, "|");
				while(tokenizer.hasMoreTokens()){
					System.out.println(tokenizer.nextToken());
				}
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
}
