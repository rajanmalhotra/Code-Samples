package com.rajan.DynamicProgramming;

/*
 * Integer (0/1) Knapsack Problem (Duplicate Items Forbidden). This is the same problem as "Making Change",
 * except here it is forbidden to use more than one instance of each type of item. 
 * Given n items of Size Si and Value Vi, fill in the capacity of C. So, maximize value within a capacity C.
 * KP[i][j] = optimal value for filling exactly a capacity j knapsack with some items from 0...i
 * as i ranges from 0..n and j ranges from 0..C, we have an order of O(nC) time and space also.
 * O(C) space is used if duplicate items are allowed.
 *  
 * KP[i][j] =  max(KP[i-1][j-arr[i]] + value[i], KP[i-1][j]), checking for all j
 * solution is find maximum of (KP[n][C])
 */

public class IntegerKnapSack {
	
	public static int fillKnapSack(int size[], int value[], int sum){
		int KP[][] = new int[value.length+1][sum+1];
		for(int i=0; i<KP.length; i++){
			KP[i][0] = 0;
		}
		for(int i=0; i<=sum; i++){
			KP[0][i] = 0;
		}
		for(int i=0; i < value.length; i++){
			for(int j=0; j < sum; j++){
				KP[i+1][j+1] = KP[i][j+1];
				if(j+1 >= size[i]){
					KP[i+1][j+1] = Math.max(KP[i+1][j+1],KP[i][j+1 - size[i]] + value[i]);
				}
					
			}
		}
		return KP[value.length][sum];		
	}
	
	public static void main(String[] args){
		int size[] =  {5, 6, 4, 3, 7, 8, 2};
		int value[] = {3, 4, 2, 5, 6, 3, 6};
		int sum = 25;
		System.out.println(fillKnapSack(size, value, sum));
	}
}
