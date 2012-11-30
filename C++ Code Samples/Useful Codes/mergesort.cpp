#include<iostream>

using namespace std;

void merge(int arr[], int start, int  mid, int end)
{
	int i=0, j=0, k=start;
	int* left = new int[mid-start+1];
	int* right = new int[end-mid];	
	
	/* Shift array's left into new left array */
	for(i=0; i < (mid-start+1); i++)
		left[i] = arr[start+i];

	/* Shift array's right into new right array */
	for(j=0; j < (end-mid); j++)
		right[j] = arr[mid+j+1];

	i = j = 0;

	/* Merge left and right into original array */
	while(i <= mid-start && j<=end-mid-1)
	{
			if(left[i] <= right[j])
				arr[k++] = left[i++];			
			else
				arr[k++] = right[j++];
	}

	if(i==mid-start+1)
	{
		while(k <= end)
			arr[k++] = right[j++];
	}
	else if(j==end-mid)
	{
		while(k <= end)
			arr[k++] = left[i++];
	}
	delete(left);
	delete(right);
}

void mergesort(int arr[], int low, int high)
{	
	if(low<high)
	{
		int mid = (low+high)/2;
		mergesort(arr, low, mid);
		mergesort(arr, mid+1, high);
		merge(arr, low, mid, high);
	}
}

void printarray(int arr[], int size)
{
	for(int i=0; i<size; i++)
		cout<<arr[i]<<" ";
	cout<<endl;
}

int main()
{	
	int arr[] = {8, 12, 19, 16, 8, 9, 10, 17, 6, 3};
	int len=10;
	cout<<"Original Array : ";
	printarray(arr, len);
	mergesort(arr, 0, len-1);

	/* print array*/
	cout<<"Merge Sort Arr : ";
	printarray(arr, len);
	getchar();
	return 0;
}