package twosigma;

import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author rajan
 * "Sorter" sorts an input consisting of strings and numbers both. 
 */
public class Sorter{

    public static void main(String[] args){        

	    String str = "";
	    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
	    
	    /* Read the input string */
		try{
	    	str = bufferRead.readLine();		 
	    }catch(IOException e)
		{
			e.printStackTrace();
		}
		
	    /* Tokenize the input string with space delimiter */
	    String delimiters = new String(" ");
	    StringTokenizer tokenizer = new StringTokenizer(str, delimiters, false);
	    List<String> allWords = new ArrayList<String>();
	    List<Integer> numbers = new ArrayList<Integer>();
	    List<String> words = new ArrayList<String>();        
	    int i=0;
	
	    while (tokenizer.hasMoreTokens()) {    
	    	String s = tokenizer.nextToken();
	    	if(isNumber(s)){
	    		numbers.add(Integer.parseInt(s));
	    	}else{
	    		words.add(s);
	    	}
	            allWords.add(s);
	    }
	        
	    /* Sort the number and string array lists individually. */
	    Collections.sort(numbers);
	    Collections.sort(words);
	
	    /* Parse the given string again and print the result accordingly. */
	    int a=0 ,b=0;
	    for(i=0; i < allWords.size(); i++){           
		    if(isNumber(allWords.get(i))){
		    	allWords.set(i, numbers.get(a++).toString());
		    }else{
		    	allWords.set(i, words.get(b++));
		    }
		}
	 
	     /* Finally print the sorted output in the desired format
	      * with no leading and trailing spaces. 
	      */
	    for(i=0; i < allWords.size(); i++){
	        if(i != allWords.size()){
	        	System.out.print(allWords.get(i)+" ");
	        }else{
	        	System.out.print(allWords.get(i));
	        }
	    }
	    System.out.println();
    }
    
	private static boolean isNumber(String str){
		try{
		    /* If string can be parsed into a number
		     * then return true
		     */
			Integer.parseInt(str);
			return true;
	    }catch(NumberFormatException ex){
	
	        /* If there is any exception while parsing the
	         * string then the provided string is not a number
	         */
	        return false;
	        }
	    }    
	}
