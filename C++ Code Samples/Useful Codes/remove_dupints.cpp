#include <iostream>
#include <map>

using namespace std;

void removedupints(int arr[], int len)
{
	map<int, bool> mymap;
	int i = 0, k = 0;
	
	for(i = 0; i < len; i++)
	{
		if(mymap[arr[i]] == false)
		{
			mymap[arr[i]] = true;
			arr[k++] = arr[i];
		}
	}
	for(i=0; i<k;i++)
		cout<<arr[i]<<" ";	
	cout<<endl;
}

int main()
{
	int arr[] = {1, 4, 44, 34, 32, 34, 3, 4, 1, 2, 4, 34, 90};
	int len = 13;
	int i;
	cout<<"Original Array : ";
	for(i=0; i<len;i++)
		cout<<arr[i]<<" ";
	cout<<"\nEdited Array : ";
	removedupints(arr, len);	
	getchar();
	return 0;
} 