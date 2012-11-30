package twosigma;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author rajan
 * DataCopier syncrhonizes data sets between different data centers
 * using minimum copy operations.
 */
public class DataCopier {

	public static void main(String[] args){

		int i=1;        
		int noOfDataCenters=0;

		/* Create a map to store the mapping of which data set is present in which data centers. 
		 * Key = DataSetId
		 * Value = List of DataCenters where the DataSetId is present 
		 */
		Map<Integer, ArrayList<Integer>> dataSets = new HashMap<Integer, ArrayList<Integer>>();

		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		try{
			noOfDataCenters = Integer.parseInt(bufferRead.readLine());         
		}catch(IOException e)
		{
			e.printStackTrace();
			System.exit(0);
		}

		while(i <= noOfDataCenters){
			try{                
				String s = bufferRead.readLine();                                
				String delimiters = new String(" ");
				StringTokenizer tokenizer = new StringTokenizer(s, delimiters, false);
				while (tokenizer.hasMoreTokens()) {    
					int num = Integer.parseInt(tokenizer.nextToken());
					ArrayList<Integer> list = dataSets.get(num);
					if(list!=null){
						list.add(i);
					}else{
						list = new ArrayList<Integer>();
						list.add(i);
					}
					dataSets.put(num, list);    
				}
			}
			catch(IOException e)
			{
				e.printStackTrace();
				System.exit(0);
			}
			i++;        
		}

		/* read from the Map */    
		System.out.println();
		for(Map.Entry<Integer, ArrayList<Integer>> entry : dataSets.entrySet()){
			int dataSetId = entry.getKey();
			ArrayList<Integer> dataCenterIds = entry.getValue();

			for(int j=1 ; j<=noOfDataCenters; j++){
				if(!dataCenterIds.contains(j)){
					/* This means that the data set is not present in the data center and
					 * hence we need to copy the data set
					 */
					System.out.println(dataSetId + " " + dataCenterIds.get(0) + " " + j);
				}
			}
		}

		/* Complete the copying operation*/
		System.out.println("done");
	}
}
