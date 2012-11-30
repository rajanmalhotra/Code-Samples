package com.rajan.crackingcoding.ch1;

//import

public class SetRowColumnZero{
	
	private int[][] arr;

	SetRowColumnZero(int[][] array){
		arr = array;
	}
		
	public void setRowColZero(){
		int len = arr.length;
		int[] rows = new int[len];
		int[] cols = new int[len];
		for(int i=0; i < len; i++){
			for(int j=0; j < arr[i].length; j++) {
				if(arr[i][j]==0){
					rows[i] = 1;
					cols[j] = 1;				
				}
			}		
		}

		for(int i=0; i < rows.length; i++){
			if(rows[i]==1){
				for(int j=0; j < arr[i].length; j++){
					arr[i][j] = 0;
				}			
			}		
		}
		for(int i=0; i < cols.length; i++){
			if(cols[i]==1){
				for(int j=0; j < len; j++){
					arr[j][i] = 0;
				}			
			}				
		}
	}

	public void printArray(){
		int len = arr.length;
		for(int i=0; i < len; i++){
			System.out.println();
			for(int j=0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
		}	
		System.out.println();
	}

	public static void main(String[] args){

		int[][] arr = 
			{{1, 2, 3, 4, 5, 6, 7, 8},
			{9,10,0,12,13,14,15,16},
			{17,18,19,20,21,22,23,24},
			{25,26,27,28,0,30,31,32},
			{33,34,35,36,37,38,39,40},
			{41,42,43,44,45,0,47,48},
			{49,50,51,52,53,54,55,56},
			{57,58,59,60,61,62,63,64}};
		SetRowColumnZero src = new SetRowColumnZero(arr);
		src.printArray();
		src.setRowColZero();
		src.printArray();		
	}
}
