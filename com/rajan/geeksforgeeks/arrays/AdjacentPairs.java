package com.rajan.geeksforgeeks.arrays;

public class AdjacentPairs {
	
	public static int heapSize = 0;
	
	public static void findAdjacentPairs(int arr[], int indices[]){
		buildMinHeap(arr, indices);
		for(int i = arr.length-1; i > 0; i--){
			swap(arr, i, 0);
			swap(indices, i, 0);
			heapSize--;
			minHeapify(arr, 0, indices);
		}
	}
	
	public static void buildMinHeap(int arr[], int indices[]){
		heapSize = arr.length;
		for(int i = heapSize/2; i >= 0; i--){
			minHeapify(arr, i, indices);
		}
	}
	
	public static void minHeapify(int arr[], int index, int indices[]){
		int left = 2*index + 1;
		int right = 2*index + 2;
		int minIndex = index;
		if(left < heapSize && arr[left] < arr[index]){
			minIndex = left;
		}
		if(right < heapSize && arr[right] < arr[minIndex]){
			minIndex = right;
		}
		if(minIndex!=index){
			/* swap array elements */
			swap(arr, minIndex, index);
			
			/* swap indices */
			swap(indices, minIndex, index);
			minHeapify(arr, minIndex, indices);
		}
	}
	
	public static void swap(int[] arr, int a, int b){
		arr[a] = arr[a] ^ arr[b];
		arr[b] = arr[a] ^ arr[b];
		arr[a] = arr[a] ^ arr[b];
	}
	
	public static void main(String[] args){
		int arr[] = {0, 3, 3, 7, 5, 3, 11, 1};
		
		/* taking O(n) extra space for saving indices */
		int indices[] = new int[arr.length];
		for(int i=0; i < indices.length; i++){
			indices[i] = i;
		}
		/* index[] = {0, 1, 2, 3, 4, 5, 6, 7}; */
		
		findAdjacentPairs(arr, indices);
		System.out.println("Sorted Array : ");
		for(int val:arr){
			System.out.print(val + " ");
		}
		System.out.println();
		System.out.println("Adjacent Indices : ");
		for(int val:indices){
			System.out.print(val + " ");
		}
		
		/* Print pairs */
		System.out.println();
		System.out.println("Pairs : ");
		for(int i=0; i<indices.length-1;i++){
			int j=1;
			while(arr[i]==arr[i+j]){
				j++;
			}
			if(j!=1){
				for(int a=i-1; a<i+j;a++){
					for(int b=a; b<i+j; b++){
						if(b!=a){
							System.out.print("("+indices[a]+","+indices[b]+"),");
						}
					}
				}
				for(int a=i; a<=i+j;a++){
					for(int b=a; b<=i+j; b++){
						if(b!=a){
							System.out.print("("+indices[a]+","+indices[b]+"),");
						}
					}
				}
			}else{
			
			System.out.print("("+indices[i]+","+indices[i+1]+"),");
			}
		}
	}
	
	
}
