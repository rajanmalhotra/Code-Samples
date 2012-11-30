#include <iostream>

using namespace std;

void removedups_arr(char str[])
{
	int i = 0, k = 0;
	bool arr[128] = {false};	
	while(str[i]!='\0')
	{
		if(arr[str[i]]==false)
		{
			arr[str[i]] = 1;
			str[k++] = str[i];			
		}
		i++;
	}
	str[k] = '\0';
	cout<<"ans : "<<str;
	cout<<endl;
}

void removedups_ptr(char str[])
{
	int i = 0, k = 0;	
	bool arr[128] = {false};			
	while(*(str+i)!='\0')
	{
		if(arr[*(str+i)]==false)
		{
			arr[*(str+i)] = 1;
			*(str+k) = *(str+i);
			k++;
		}
		i++;
	}
	*(str+k) = '\0';	
	cout<<"ans : "<<str;
	cout<<endl;	
}

int main()
{
	char str[] = "rajan_majan_sajan";
	removedups_arr(str);
	removedups_ptr(str);
	getchar();
	return 0;
} 