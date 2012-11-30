package ComputationalBiology;

import java.io.*;
import java.util.Scanner;

public class CreateStringFromFile {

	public void createString(){
		File file = new File("/home/rajan/Work_MS/Subjects/Comp Bio/reads.2k.10x.fasta");
		String str = "";
		
		try{
			FileWriter fstream = new FileWriter("/home/rajan/Work_MS/Subjects/Comp Bio/readsFiltered");
			BufferedWriter out = new BufferedWriter(fstream);
			
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()){
				scanner.nextLine();
				out.write(scanner.nextLine());
				out.newLine();
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}		
	}
	
	public static void main(String[] args){
		CreateStringFromFile c = new CreateStringFromFile();
		c.createString();
	}
}
