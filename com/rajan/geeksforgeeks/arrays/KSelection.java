package com.rajan.geeksforgeeks.arrays;

/*
 * K-Selection Algo : to find the Kth Largest element in the array.
 * It runs on the lines of quick sort and takes linear time.
 */

public class KSelection {

	public static void swap(int arr[], int a,  int b){
		if(a!=b){
			arr[a] = arr[a] ^ arr[b];
			arr[b] = arr[a] ^ arr[b];
			arr[a] = arr[a] ^ arr[b];
		}
	}

	public static int partition(int arr[], int left, int right, int index){
		if(left==right){
			return left;
		}

		int pivot = arr[index];
		swap(arr, right, index);
		while(left < right){
			while(arr[left] > pivot){
				left++;
			}
			while(arr[right] < pivot){
				right--;
			}
			swap(arr, left, right);
		}
		return left;
	}
	
	public static int kSelect(int arr[], int left, int right, int K){
		int index=0;
		if(K <= 0){
			System.out.println("Give a value to K, greater than 0");
		}
		
		K=K-1;
		int leftTotal = 0;
		while(left <= right){
			index = (left+right)/2;
			index = partition(arr, left, right, index);
			leftTotal = index-left+1;
			if(index == K){
				return arr[index];
			}else if(K < leftTotal){
				right = index-1;
			}else{
				K = K - leftTotal;
				left = index+1;
			}
		}
		return arr[left];
	}
	
	public static void main(String[] args){
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 ,13, 14 ,15, 16};
		for(int i=1; i <=arr.length; i++){
			System.out.println(i + "th Largest Element is : " + kSelect(arr, 0, arr.length-1, i));
		}
	}
}
