package com.rajan.DynamicProgramming;

/*
 * Goal: Make change for amount of money C. Use as few as coins possible.
 * It is equivalent to Integer KnapSack
 */

public class ChangeMaker {
	
	/* 
	 * M[j] = minimum coins required to make change for amount of money j
	 * M[j] = Over all i, min{ M[j-denom[i]] } + 1
	 */
	private static int min = Integer.MAX_VALUE;
	private static int denom[] = {1, 5, 10, 25};
	
	/* Recursion : Not Optimized */
	public static void makeChangeR(int C, int count){
		if(C<0){
			return;
		}
		if(C==0 && min > count){
			min = count;
		}
		
		for(int i=0; i < denom.length; i++){
			makeChangeR(C - denom[i], count+1);
		}
	}
	
	/* Using Dynamic Programming */
	public static int makeChangeI(int cost, int coins[]){
		int ways=0;
		for(int i=1; i <= cost; i++){
			ways = 0;		
			for(int j=0; j < denom.length; j++){
				if(i >= denom[j]){
					ways = coins[i-denom[j]] + 1;
				}
				if(coins[i]==0 || ways < coins[i]){
					coins[i] = ways;
				}
			}
		}
		return coins[cost];
	}
	
	public static void main(String[] args){
		int cost = 70;
		int coins[] = new int[cost+1];
		for(int i=0; i < coins.length; i++){
			coins[i] = 0;
		}
		//makeChangeR(cost, 0);	// can take lot of time for big values
		//System.out.println("Minimum Coins required for making " + cost + " is : " + min);
		System.out.println("Minimum Coins required for making " + cost + " is : " + makeChangeI(cost, coins));
	}
}
