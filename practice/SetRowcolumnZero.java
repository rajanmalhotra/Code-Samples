package practice;

class SetRowcolumnZero{
	public static void main(String[] args){
		int[][] arr = {{1, 2, 3, 4, 5},
				   {6, 7, 8, 9, 10}, 
				   {11, 12, 0, 14, 15}, 
				   {16, 17, 18, 19, 20}};
		int row[] = new int[arr.length];
		int col[] = new int[arr[0].length];
		for(int i=0; i < arr.length; i++){
			for(int j=0; j < arr[0].length; j++){
				if(arr[i][j]==0){
					row[i] = 1;
					col[j] = 1;			
				}
			}	
		}
		for(int i=0; i < arr.length; i++){
			for(int j=0; j < arr[0].length; j++){
				if(row[i]==1 || col[j]==1){
					arr[i][j]=0;				
				}			
			}		
		}

		for(int i=0; i < arr.length; i++){
			for(int j=0; j < arr[0].length; j++){
				System.out.println(arr[i][j]);
			}
		}	
	}
}
