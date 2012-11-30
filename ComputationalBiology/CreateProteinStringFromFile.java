package ComputationalBiology;

import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CreateProteinStringFromFile {
  
	public String createString(){
		File file = new File("/home/rajan/Desktop/sampleProtein");
		String str = "";
		try{
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()){
				StringTokenizer st = new StringTokenizer(scanner.nextLine());
				st.nextElement();
				while(st.hasMoreTokens()){
					str+=(String)st.nextElement();
				}				
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		System.out.println(str.length() + " : " + str);
		return str;
	}
	
	public static void main(String[] args){
		CreateProteinStringFromFile c = new CreateProteinStringFromFile();
		c.createString();
	}
}
