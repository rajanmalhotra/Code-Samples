//# include <iostream>
//
//using namespace std;
//
//int secondmax(int arr[], int len)
//{
//	int i=1;
//	int max, sec_max;
//	sec_max = -1000;
//	max = arr[0];
//	for(i=1; i<len; i++)
//	{
//		if(arr[i]>max)
//		{
//			sec_max = max;
//			max = arr[i];
//		}	
//		else if(arr[i] > sec_max)
//		{
//			sec_max = arr[i];
//		}				
//	}
//	return sec_max;
//}
//
//int main()
//{
//
//	int arr[] = {7571, 8758, 4574, 9797, 8632, 7648, 25743, 2314, 17600, 8521, 774, 5534, 9651};
//	int len = 13;
//	int i;
//	cout<<"Original Array : ";
//	for(i=0; i<len;i++)
//		cout<<arr[i]<<" ";
//	cout<<"\nSecondMax : ";
//	cout<<secondmax(arr, len)<<endl;
//	//getchar();
//	return 0;
//}
//
