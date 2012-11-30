package practice;

class UniqueChecker{

	public static void main(String[] args){
		int checker = 0;
		int i = 0;
		String str = "rajn";		
		while(i!=str.length()){
			int val = str.charAt(i) - 'a';
			if((checker & (1<<val)) > 0){
				System.out.println("Not Unique");
				return;
			}
			i++;
			checker |= (1<<val);
		}
		System.out.println("unique");
	}
}

/*
Null Checks / Initializations
Increments of counters
Return values
*/
