#include<iostream>

using namespace std;

bool check_anagram(char str1[], char str2[])
{
	int i=0;
	int diff=0;
	int arr[128] = {0};
	
	while(str1[i]!='\0')
		arr[str1[i++]]++;
	i=0;
	while(str2[i]!='\0')
	{
		arr[str2[i]]--;
		if(arr[str2[i++]]<0)
			return false;		
	}
	return true;
}

int main()
{
	bool flag=false;
	char str1[] = "I AMLORD VOLDEMORT";
	char str2[] = "TOM MARVOLO RIDDLE";
	flag = check_anagram(str1, str2);
	cout<<"Ans : "<<flag;
	getchar();
}
