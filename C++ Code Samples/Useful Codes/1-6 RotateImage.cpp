#include <iostream>

using namespace std;

void swap(char *val1, char *val2)
{
	*val1 = *val1 - *val2;
	*val2 = *val2 + *val1;
	*val1 = *val2 - *val1;
}

void rotateimage(char arr[][8], int dim)
{
	int i, j;
	i = j = 0;
	for(i=0; i < dim/2; i++)
		for(j=0; j < dim/2; j++){
			swap(&arr[i][j], &arr[dim-j-1][i]);
			swap(&arr[i][j], &arr[dim-i-1][dim - j-1]);
			swap(&arr[i][j], &arr[j][dim-i-1]);
		}
}

void shift(char *val1, char *val2)
{
	*val1 = *val2;
}

void rotateimage_4rds(char arr[][8], int dim)
{
	int i, j;
	i = j = 0;
	char temp;

	for(i=0; i < dim/2; i++){
		for(j=0; j < dim/2; j++){
			temp = arr[i][j];
			arr[i][j] = arr[dim-j-1][i];
			arr[dim-j-1][i] = arr[dim-i-1][dim-j-1];
			arr[dim-i-1][dim - j-1] = arr[j][dim-i-1];
			arr[j][dim-i-1] = temp;
		}
	}
}

void printarr(char arr[][8], int dim)
{
	for(int i =0; i < dim; i++)
	{
		for(int j = 0; j< dim; j++)
			cout<<arr[i][j]<<" ";
		cout<<endl;
	}
}

int main()
{
	int dim = 8;
	char arr[8][8]= 
	{
		'*','*','*','*','-','-','-','-',
		'0','0','0','0','0','0','0','0',
		'*','*','*','*','*','*','*','*',
		'-','-','-','-','-','-','-','-',
		'-','-','-','-','-','-','-','-',
		'*','*','*','*','*','*','*','*',
		'0','0','0','0','0','0','0','0',
		'*','*','*','*','-','-','-','-',
	};
	//{1, 2, 3, 4, 5, 6, 7, 8,
	//9,10,11,12,13,14,15,16,
	//17,18,19,20,21,22,23,24,
	//25,26,27,28,29,30,31,32,
	//33,34,35,36,37,38,39,40,
	//41,42,43,44,45,46,47,48,
	//49,50,51,52,53,54,55,56,
	//57,58,59,60,61,62,63,64};
	
	printarr(arr, dim);
	cout<<endl<<"Rotated Image : "<<endl<<endl;
	rotateimage(arr, dim);
	printarr(arr, dim);
	rotateimage_4rds(arr, dim);
	cout<<endl<<"Another Rotation : "<<endl<<endl;
	printarr(arr, dim);
	getchar();
	return 0;
}