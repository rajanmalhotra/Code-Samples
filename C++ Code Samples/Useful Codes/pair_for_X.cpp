#include <iostream>
#include <map>

using namespace std;

void pairforX(int arr[], int len, int X)
{
	int i=0;
	map<int, int> mymap;
	for(i=0; i < len; i++)
	{
		if(mymap.count(X-arr[i]) > 0)
		{
			cout<<"Pairs found are : "<<arr[i]<<" and "<<X-arr[i]<<endl;			
			mymap[X-arr[i]]--;
		}
		else
			mymap[arr[i]]++; 
	}
}

int main()
{
	int arr[] = {8, 12, 19, 16, 8, 9, 10, 17, 6, 3, 5, 13, 7};
	int X = 22;
	int len = 13;

	/* using additional data structure */
	pairforX(arr, len, X);
	getchar();
	return 0;
}