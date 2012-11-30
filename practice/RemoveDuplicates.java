package practice;

class RemoveDuplicates{
	public static void main(String[] args){
		String str = "Rajan Malhotra";
		char[] arr = str.toCharArray();
		int tail=0;
		int j=0;		
		for(int i=1; i < arr.length; i++){
			for(j=0; j<tail; j++){
				if(arr[j]==arr[i]){
					break;
				}	
			}
			if(j==tail){
				arr[++tail] = arr[i];			
			}
		}
		System.out.println(new String(arr, 0, tail+1));
	}
}

/*
Null Checks / Initializations
Increments of counters
Return values
*/
