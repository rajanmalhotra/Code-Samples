package nRelate;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Tester1 {
	
	 //public static double cosine_similarity(Map<String, Double> v1, Map<String, Double> v2) {
	public static double cosine_similarity(Map<String, ArrayList<Integer>> v1, Map<String, ArrayList<Integer>> v2) {
		Set<String> combination = new HashSet<String>(v1.keySet());
		combination.retainAll(v2.keySet());
		double sclar = 0, norm1 = 0, norm2 = 0;
		
		for (String k : combination){
			ArrayList<Integer> list1 = v1.get(k);
			ArrayList<Integer> list2 = v2.get(k);
			int len1 = list1.size();
			int len2 = list2.size();
			int len = Math.max(list1.size(), list2.size());
			int a=0;
			int b=0;
			for ( int ctr = 0; ctr < len; ctr++){
				try{
				a = list1.get(ctr);
				}catch(Exception ex){
					a = 1;//list1.get(len1-1);
				}
				try{
					b = list2.get(ctr);
				}catch(Exception ex){
					b = 1;//list2.get(len2-1);
				}
				sclar += a*b;
			}
		}
		for (String k : v1.keySet()){
			ArrayList<Integer> list1 = v1.get(k);
			for ( int ctr = 0; ctr < list1.size(); ctr++){
				norm1 += list1.get(ctr) * list1.get(ctr);
			}
		}
		for (String k : v2.keySet()){
			ArrayList<Integer> list2 = v2.get(k);
			for ( int ctr = 0; ctr < list2.size(); ctr++){
				System.out.println(list2.get(ctr));
				norm2 += list2.get(ctr) * list2.get(ctr);
			}
		}
		System.out.println("Sum of List 1 (AxA) : " + norm1);
		System.out.println("Sum of List 2 (BxB) : " + norm2);
		System.out.println(sclar);
		return sclar / (Math.sqrt(norm1) * Math.sqrt(norm2));
	}
	
	public static void main(String[] args){
		Map<String, ArrayList<Integer>> myMap1 = new TreeMap<String, ArrayList<Integer>>();
		Map<String, ArrayList<Integer>> myMap2 = new TreeMap<String, ArrayList<Integer>>();
		try{
			BufferedReader br = new BufferedReader(new FileReader("/home/rajan/Desktop/test.txt"));
			String line=null;
			int noOfIds=0;
			String Id = null;
			int num;
			int lineCount=0;
			
			while ((line = br.readLine()) != null) {
				if(lineCount==0){
					StringTokenizer tokenizer = new StringTokenizer(line, ",", false);
					if(tokenizer.hasMoreTokens()){
						noOfIds = Integer.parseInt(tokenizer.nextToken());
					}
					int i=0;
					while (tokenizer.hasMoreTokens()) {
						if(i%2==0){
							Id = tokenizer.nextToken();
							if(!myMap1.containsKey(Id)){
								myMap1.put(Id, new ArrayList<Integer>());	
							}
						}else{
							num = Integer.parseInt(tokenizer.nextToken());
							ArrayList<Integer> list = myMap1.get(Id);
							list.add(num);
							myMap1.put(Id, list);
						}
						i++;
					}
					lineCount++;
				}else{
					StringTokenizer tokenizer = new StringTokenizer(line, ",", false);
					if(tokenizer.hasMoreTokens()){
						noOfIds = Integer.parseInt(tokenizer.nextToken());
					}
					int i=0;
					while (tokenizer.hasMoreTokens()) {
						if(i%2==0){
							Id = tokenizer.nextToken();
							if(!myMap2.containsKey(Id)){
								myMap2.put(Id, new ArrayList<Integer>());	
							}
						}else{
							num = Integer.parseInt(tokenizer.nextToken());
							ArrayList<Integer> list = myMap2.get(Id);
							list.add(num);
							myMap2.put(Id, list);
						}
						i++;
					}
				}
			}
			System.out.println(myMap1);
			System.out.println("==============================");
			System.out.println(myMap2);			
		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println("Exception");
		}
		double result = cosine_similarity(myMap1, myMap2);
		System.out.println(result);
	}
}
