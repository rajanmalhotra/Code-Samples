package com.rajan.sorts;

public class HeapSort {

	public static int heapSize;
	public void heapSort(int[] arr){
		buildMaxHeap(arr);
		for(int i=arr.length-1 ; i>0; i--){
			arr[i] = arr[i] + arr[0];
			arr[0] = arr[i] - arr[0];
			arr[i] = arr[i] - arr[0];
			heapSize--;
			maxHeapify(arr, 0);
		}
	}
	
	public void buildMaxHeap(int[] arr){
		heapSize = arr.length;
		for(int i = heapSize/2; i >= 0; i--){
			maxHeapify(arr, i);
		}
	}
	
	public void maxHeapify(int[] arr, int index){
		int left = getLeft(index);
		int right = getRight(index);
		int largest = 0;
		if(left < heapSize && arr[left] > arr[index]){
			largest = left;
		}else{
			largest = index;
		}
		if(right < heapSize && arr[right] > arr[largest]){
			largest = right;
		}
		if(largest!=index){
			arr[index] = arr[index] + arr[largest];
			arr[largest] = arr[index] - arr[largest];
			arr[index] = arr[index] - arr[largest];
			maxHeapify(arr, largest);
		}
	}
	
	public int getLeft(int index){
		return 2*index+1;
	}
	
	public int getRight(int index){
		return 2*index+2;
	}
	
	public static void main(String[] args){
		int[] arr = {0, 3, 3, 7, 5, 3, 11, 1};//4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
		HeapSort heap = new HeapSort();
		heap.heapSort(arr);
		for(int val : arr){
			System.out.println(val);
		}
	}
}
