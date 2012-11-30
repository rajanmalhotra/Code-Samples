package com.rajan.DynamicProgramming;

/*
 * Balanced Partition. You have a set of n integers each in the range 0 ... K. 
 * Partition these integers into two subsets such that you minimize |S1 - S2|, 
 * where S1 and S2 denote the sums of the elements in each of the two subsets.
 * 
 * Similar to Integer KnapSack with a goal to minimize | sum(S1) - Sum(S2) |
 * 
 * P[i][j] =	{	1 		if some subset of arr[0]... arr[i] has a sum of j,
 * 				{   0		otherwise
 * 
 * order : 1...n * 0...nK = O(n^2 * K)
 * 
 * P[i][j] = 	{ 	1		if P[i-1][j] = 1 or P[i-1][j-arr[i]] = 1,
 * P[i][j] = max { P[i-1][j], P[i-1][j-arr[i]] } 
 * 
 * Let S = sum(arr[i]) / 2 - all elements divide by 2
 * Hence, now find min { S - i }, for all i <= S.
 * 
 * Sum(S1) = i and Sum(S2) = 2S - i
 */
public class BalancedPartition {

}
