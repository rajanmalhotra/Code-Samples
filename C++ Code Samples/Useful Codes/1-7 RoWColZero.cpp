#include <iostream>

using namespace std;

void printarr(int arr[8][8], int dim)
{
	for(int i =0; i < dim; i++)
	{
		for(int j = 0; j< dim; j++)
			cout<<arr[i][j]<<" ";
		cout<<endl;
	}
}

void makezeros(int arr[][8], int dim)
{
	int i, j;
	int row[8] = {0};
	int col[8] = {0};
	for(i=0; i < dim; i++)
		for(j=0; j < dim; j++){
			if(arr[i][j]==0){
				row[i] = 1;
				col[j] = 1;
			}
		}

	for(i=0; i < dim; i++)
		for(j=0; j < dim; j++){
			if(row[i]==1 || col[j]==1)
				arr[i][j]=0;
		}
}

int main()
{
	int dim = 8;
	int arr[][8]=
	{1, 2, 3, 4, 5, 6, 7, 8,
	9,10,0,12,13,14,15,16,
	17,18,19,20,21,22,23,24,
	25,26,27,28,0,30,31,32,
	33,34,35,36,37,38,39,40,
	41,42,43,44,45,0,47,48,
	49,50,51,52,53,54,55,56,
	57,58,59,60,61,62,63,64};
	
	printarr(arr, 8);
	makezeros(arr, 8);
	printarr(arr, 8);
	getchar();
	return 0;
}