package com.rajan.geeksforgeeks.bits;

public class NextHigherNumber {
	public int findNextHighestNumber(int num){
		int lmask = 1;
		int umask = 2;
		int lowerIndex = 0;
		
		while(true){
			if((num & umask)==0 && (num & lmask)>1){
				break;
			}
			umask = umask << 1;
			lmask = lmask << 1;			
			lowerIndex++;
		}
		int set1 = (num >> lowerIndex) & 1;//((1<<1)-1);
		int set2 = (num >> (lowerIndex+1)) & 1;//((1<<1)-1);
		int xorRes = set1 ^ set2;
		xorRes = (xorRes << lowerIndex) | (xorRes << (lowerIndex+1));
		return num ^ xorRes;
	}
	
	public static void main(String[] args){
		NextHigherNumber n = new NextHigherNumber();
		System.out.println(n.findNextHighestNumber(156));
	}
}
