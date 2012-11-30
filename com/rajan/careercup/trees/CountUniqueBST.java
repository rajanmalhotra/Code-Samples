package com.rajan.careercup.trees;

public class CountUniqueBST {
	
	public static void main(String[] args){
		int N = 7;
		int res = 0;
		int T[] = new int[N+1];
		T[0] = 1;
		for(int i=1; i<=N; i++){
			res = 0;
			for(int j=0; j<i; j++){
				res += T[j]*T[i-j-1];
			}
			T[i] = res;
		}
		for(int i=1; i <= N; i++){
			System.out.print(T[i] + " ");
		}
	}
}
