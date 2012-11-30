package ComputationalBiology;

public class LongORFFinder {

	public String findLongORF(String base){
		//String start = "ATG";
		String end[] = {"TAG", "TGA", "TAA"};
		int len = base.length();
		int current = 0;
		int start = 0;
		int startIndex = 0;
		int endIndex = 0;
		
		/* Check in 3 different cases for stop codons */
		for(int i=0; i<3; i++){
			current = i;
			start = i;
			
			while(current+3<len){
				for(int j=0; j < end.length; j++){
					
					/* looking for STOP codon */
					if(base.substring(current, current+3).equals(end[j])){
						System.out.println("The start and end of the LORF is found at : " + start + " and " + (current-1));
						System.out.println("The LORF of " + (current-start)/3 + " codons is : " + base.substring(start, current));
						if(endIndex-startIndex < current-start){
							endIndex = current-1;						
							startIndex = start;	
						}
						start = current + 3;
					}
				}
				current = current + 3;
			}
		}		

		System.out.println("============================================================================");
		System.out.println("The longest LORF is found between indices : " + startIndex + " and " + endIndex);
		System.out.println("The longest LORF of " + (endIndex-startIndex+1)/3 + " codons is : " + base.substring(startIndex, endIndex+1));
		System.out.println("============================================================================");
		return null;
	}
	
	public static void main(String[] args){
		CreateStringFromFile cs = new CreateStringFromFile();
		String base = cs.createString();
		LongORFFinder lorf = new LongORFFinder();
		lorf.findLongORF(base);
	}
}
