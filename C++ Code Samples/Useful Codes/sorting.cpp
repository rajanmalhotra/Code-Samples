#include <iostream>

using namespace std;

void insertionSort(int a[], int n)
{
	for(int i= 1; i<n; i++)
	{
		int num = a[i];
		int j = i-1;
		for(; j>=0; j--)
		{
			if(a[j] >  num)
				a[j+1] = a[j];
			else
				break;
		}
		a[j+1] = num;
	}
}


void selectionSort(int a[], int n)
{
	for(int i=0;i<n;i++)
	{
		int max = a[i];
		int pos = i;
		for(int j=i+1; j<n;j++)
		{
			if(a[j] > max)
			{
				max = a[j];
				pos = j;
			}
		}

		int temp = a[i];
		a[i] = max;
		a[pos] = temp;
	}
}

void bubbleSort(int a[], int n)
{
	int temp;
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n-i-1;j++)
		{
			if(a[j] > a[j+1])
			{
				temp = a[j];
				a[j]=a[j+1];
				a[j+1]=temp;
			}
		}
	}
}

void merge(int a[], int l, int m, int h)
{
	int ptr1 = l, ptr2 = m+1, ptr3 = 0;
	int *b =  new int[h-l+1];

	while(ptr1 <= m && ptr2 <= h)
	{
		if(a[ptr1] < a[ptr2])
			b[ptr3++] = a[ptr1++];
		else
			b[ptr3++] = a[ptr2++];
	}

	if(ptr1 <= m)
	{
		while(ptr1 <= m)
		{
			b[ptr3++] = a[ptr1++];
		}
	}

	if(ptr2 <= h)
	{
		while(ptr2 <= h)
		{
			b[ptr3++] = a[ptr2++];
		}
	}

	//Copy the merged array back to the original array
	//int size = h-l+1;
	for(int i=l;i<=h;i++)
	{
		a[i] = b[i];
	}
}

void mergeSort(int a[], int l, int h)
{
	int mid;
	if(l<h)
	{
		mid = (l+h)/2;
		mergeSort(a, l, mid);
		mergeSort(a, mid+1, h);
		merge(a, l, mid, h);
	}
}

void display(int a[], int n)
{
	for(int i=0;i<n;i++)
		cout<<a[i]<<endl;
	cout<<"========================\n";
}



void swap(int *x,int *y)
{
   int temp;
   temp = *x;
   *x = *y;
   *y = temp;
}

int choose_pivot(int i,int j )
{
   return((i+j) /2);
}

void quicksort(int list[],int m,int n)
{
   int key,i,j,k;
   if( m < n)
   {
      k = choose_pivot(m,n);
      swap(&list[m],&list[k]);
      key = list[m];
      i = m+1;
      j = n;
      while(i <= j)
      {
         while((i <= n) && (list[i] <= key))
                i++;
         while((j >= m) && (list[j] > key))
                j--;
         if( i < j)
                swap(&list[i],&list[j]);
      }
      // swap two elements
      swap(&list[m],&list[j]);
      // recursively sort the lesser list
      quicksort(list,m,j-1);
      quicksort(list,j+1,n);
   }
}






int main()
{
	int a[] = {5,8,1,4,9,10,3};
	int size = sizeof(a)/sizeof(a[0]);
	insertionSort(a,size);
	display(a,size);

	int b[] = {5,8,1,4,9,10,3};
	selectionSort(b,size);
	display(b,size);

	int c[] = {5,8,1,4,9,10,3};
	bubbleSort(c,size);
	display(c,size);

	int d[] = {5,8,1,4,9,10,3};
	mergeSort(d,0,6);
	display(d,7);

	int e[] = {4,1};
	merge(e, 0,0, 1);
	display(e,2);

	int f[] = {1,4,7,2,3,6,8};
	quicksort(f,0,6);
	display(e,7);

}