package com.rajan.geeksforgeeks.arrays;

/*
 * Problem 2:
 * Dynamic Programming | Set 20 (Maximum Length Chain of Pairs)
 * You are given n pairs of numbers. In every pair, the first number is always smaller than the 
 * second number. A pair (c, d) can follow another pair (a, b) if b < c. Chain of pairs can be 
 * formed in this fashion. Find the longest chain which can be formed from a given set of pairs.
 * For example, if the given pairs are {{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90} }, then the
 * longest chain that can be formed is of length 3, and the chain is {{5, 24}, {27, 40}, {50, 90}}
 */

public class MaxLengthChainOfPairs {
	public int longestChainOfPair(pair[] arr){
		int LC[] = new int[arr.length];
		LC[0] = 1;
		int maxn = 0;
		
		for(int i=1; i < arr.length ; i++){
			maxn=0;
			for(int j=0; j < i; j++){
				if(arr[j].b < arr[i].a && LC[j] > maxn){
					maxn = LC[j];
				}
			}
			LC[i] = maxn + 1;
		}
		
		maxn=0;
		for(int i=0; i < LC.length; i++){
			if(LC[i] > maxn){
				maxn = LC[i];
			}
		}
		return maxn;
	}
	
	public static void main(String[] args){
		pair[] arr = {new pair(5, 24), new pair(39, 60), new pair(15, 28),
						new pair(27, 40), new pair(50, 90)};
		MaxLengthChainOfPairs m = new MaxLengthChainOfPairs();
		System.out.println(m.longestChainOfPair(arr));
	}
}

class pair{
	int a;
	int b;
	pair(int a, int b){
		this.a = a;
		this.b = b;
	}
}