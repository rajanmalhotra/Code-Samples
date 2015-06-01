package practice;

/*
 * Sort an array of 0s, 1s and 2s
 * Given an array A[] consisting 0s, 1s and 2s, write a function that sorts A[]. 
 * The functions should put all 0s first, then all 1s and all 2s in last.
 * Example
 * Input = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
 * Output = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}
 * The problem is similar to our old post Segregate 0s and 1s in an array, 
 * and both of these problems are variation of famous Dutch national flag problem.

 * */

public class dutchNationalFlag {
	
	public static void arrangeNumbers(int[] arr, int size){
		int low = 0;
		int high = size-1;
		int i = 0;
		while(i <= high){
			if(arr[i] < 1){
				swap(arr, i, low);
				low++;
				i++;
			}else if(arr[i] > 1){
				swap(arr, i, high);
				high--;
			}else{
				i++;
			}
		}
	}
	
	public static void swap(int[] arr, int i, int j){
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
	}
	
	public static void main(String[] args){
		int arr[] = {0, 1, 2, 2, 0, 0, 1, 2, 1, 0, 1, 2, 2, 1, 0, 0, 1, 2, 0, 1};
		for(int val:arr){
			System.out.print(val + " ");
		}
		arrangeNumbers(arr, arr.length);
		System.out.println();
		for(int val:arr){
			System.out.print(val + " ");
		}
	}
}
