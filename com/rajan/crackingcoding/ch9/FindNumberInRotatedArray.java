package com.rajan.crackingcoding.ch9;

public class FindNumberInRotatedArray {
	public static void main(String[] args){
		int[] arr = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
		System.out.println("The number is that index : " + findNumber(arr, 0, arr.length-1, 10));
	}
	
	
	public static int findNumber(int[] arr, int start, int end, int num){
	    if(start > end){
	        return -1;
	    }

		int result=0;
		int mid = (start + end)/2;
		if(arr[mid]==num){
		    return mid;
		}

		/* Case of lower half of increasing order upper half divided into 2 and 1 upper half of increasing order */
		else if(arr[start] < arr[mid]){
		    if(num > arr[mid]){
		        result = findNumber(arr, mid+1, end, num);
		    }else if(num >= arr[start]){
		    	result = findNumber(arr, start, mid-1, num);
		    }else {
		    	result = findNumber(arr, mid+1, end, num);
		    }
		}

		/* Case of lower half divided into 2 and 1 upper half of increasing order */
		else if(num < arr[mid]){
		    result = findNumber(arr, start, mid-1, num);
		}else if(num < arr[end]){
		    result = findNumber(arr, mid+1, end, num);
		}else{
			result = findNumber(arr, start, mid-1, num);
		}
		return result;
	}
}
