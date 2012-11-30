package ComputationalBiology;

import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

public class createArrFromFile {
	
	public String createArray(){
		File file = new File("/home/rajan/Desktop/sampleNum");
		String str = "";
		try{
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()){
				str = "{";
				StringTokenizer st = new StringTokenizer(scanner.nextLine());
				st.nextElement();
				while(st.hasMoreTokens()){
					int val = Integer.parseInt((String)st.nextElement());
					if(val>=0){
						str = str + " " + val + ",";
					}else{
						str = str + val + ",";
					}
					
				}
				str += "},";
				System.out.println(str);
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		//System.out.println(str.length() + " : " + str);
		return str;
	}
	
	public static void main(String[] args){
		createArrFromFile c = new createArrFromFile();
		c.createArray();
	}
}
