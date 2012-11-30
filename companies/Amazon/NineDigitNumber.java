package companies.Amazon;

/*
 * Problem 81: you are given nos 1,2 ,3 ,4 ,5 ,6 ,7 ,8 ,9. You hav to form a 9 digit no such that 1st 2 digits 
 * are divisible by 2, 1st 3 digits are divisible by 3,1st 4 digits are divisible by 4 and so on..... 
 * (repetitions not allowed)
 */

public class NineDigitNumber {

	public void createNumber(boolean used[], int level, int num){	
		if(level == used.length){
			System.out.println(num);
			return;
		}

		int len = used.length;
		int sum = 0;
		int val = 0;
		switch(level){
			case 2 :
				for(int i=0; i < len; i=i+2){
					used[i] = true;
					for(int j=0; j < len; j++){
						if(!used[j]){
							num = j*10 + i;
							used[j] = true;
							createNumber(used, level+1, num);
						}
					}
				}
				break;
			case 3 :
				sum = (num/10) + (num%10);
				for(int j=0; j < len; j++){
					if(!used[j] && ((sum+j)%3 == 0)){
						num = num*10 + j;
						used[j] = true;
						createNumber(used, level+1, num);
					}
				}
				break;

			case 4 : 
				for(int i=0; i < len; i=i+2){
					val = num*10 + i;
					if(!used[i] && (val%100)%4==0){
						used[i] = true; 
						createNumber(used, level+1, val);
					}
				}

				break;
			case 5 : 
				for(int i=0; i < len; i+=5){
					val = num*10 + i;
					if(!used[i]){
						used[i] = true;
						createNumber(used, level+1, val);
					}	
				}
				break;
			case 6 : break;
			case 7 : break;
			case 8 : break;
			case 9 : break;
		}		
	}
	
	public static void main(String[] args){
		boolean[] used = new boolean[6];
		NineDigitNumber n = new NineDigitNumber();
		n.createNumber(used, 2, 0);	
	}
}
