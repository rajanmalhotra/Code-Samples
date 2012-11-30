#include <iostream>
#include <vector>
#include <map>

using namespace std;
vector<int> vectarr;

void unionarrs(int arr1[], int arr2[], int len1, int len2)
{
	int i=0;
	map<int, int> mymap;	
	vectarr.clear();

	for(i=0; i < len1; i++)
		if(mymap.count(arr1[i])==0)
		{
			mymap[arr1[i]]++;
			vectarr.push_back(arr1[i]);
		}		
	
	for(i=0; i < len2; i++)
		if(mymap.count(arr2[i])==0)
		{
			mymap[arr2[i]]++;
			vectarr.push_back(arr2[i]);
		}
	
}

void intersectarrs(int arr1[], int arr2[], int len1, int len2)
{
	int i=0;
	map<int, int> mymap;
	vectarr.clear();

	for(i=0; i < len1; i++)
		if(mymap.count(arr1[i])==0)		
			mymap[arr1[i]]++;			
	
	for(i=0; i < len2; i++)
		if(mymap.count(arr2[i])==1)			
			vectarr.push_back(arr2[i]);
}

void unionusingarr(int arr1[], int arr2[], int len1, int len2)
{
	int i=0, j=0;
	vectarr.clear();
	vectarr.push_back(arr1[i]);

	while(i<len1 && j<len2)
	{
		if(arr1[i] <= arr2[j])
		{	
			if(arr1[i] > vectarr.back())
				vectarr.push_back(arr1[i]);
			i++;			
		}
		else if(arr1[i] > arr2[j])
		{
			if(arr2[j] > vectarr.back())
				vectarr.push_back(arr2[j]);
			j++;
		}
	}

	// Array 1 is still having elements
	while(i<len1)
	{
		if(arr1[i] > vectarr.back())
				vectarr.push_back(arr1[i]);
		i++;			
	}
	
	// Array 2 is still having elements
	while(j<len2)
	{
		if(arr2[j] > vectarr.back())
				vectarr.push_back(arr2[j]);
		j++;			
	}
}

int main()
{
	//int arr1[] = {75, 88, 74, 97, 862, 68, 73, 14, 14, 88, 74, 55, 51};
	//int arr2[] = { 170, 85, 74, 55, 50, 75, 88, 9, 62, 68, 3, 14};
	int arr1[] = {2, 2, 2, 3, 7, 7, 7, 8};
	int arr2[] = {2, 3, 9, 10};

	int len1 = 8;
	int len2 = 4;
	int i;

	cout<<"original Arrays : "<<endl;
	
	cout<<"First Array : ";
	for(i=0; i<len1;i++)
		cout<<arr1[i]<<" ";
	cout<<endl;
	cout<<"Second Array : ";
	for(i=0; i<len2;i++)
		cout<<arr2[i]<<" ";

	cout<<endl<<endl<<"Union of the Arrays : ";
	unionarrs(arr1, arr2, len1, len2);
	for(i=0; i < (int)vectarr.size(); i++)
		cout<<vectarr[i]<<" ";
	
	cout<<endl<<endl<<"Intersection of the Arrays : ";
	intersectarrs(arr1, arr2, len1, len2);
	for(i=0; i < (int)vectarr.size(); i++)
		cout<<vectarr[i]<<" ";

	cout<<endl<<endl<<"Union of the Arrays (w/o map,vetor) : ";
	unionusingarr(arr1, arr2, len1, len2);
	for(i=0; i < (int)vectarr.size(); i++)
		cout<<vectarr[i]<<" ";

	getchar();
	return 0;
}

