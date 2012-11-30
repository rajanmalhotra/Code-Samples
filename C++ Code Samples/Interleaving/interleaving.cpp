#include <iostream>

using namespace std;

bool isInterleaving(char* str1, char* str2, char* interleaved)
{
	int i = strlen(str1);
	int j = strlen(str2);
	int k = strlen(interleaved);
	
	bool flag1 = false;
	bool flag2 = false;
	if((i + j) != k)
		return false;
	
	if(i==0 && j==0 && k==0)
		return true;
	if(*(interleaved) == *(str1))
		flag1 = flag1 | isInterleaving(str1+1, str2, interleaved+1);
	
	if(!flag1 && *(interleaved) == *(str2))
		flag1 = flag1 | isInterleaving(str1, str2+1, interleaved+1);
		
	return flag1;
}

int main()
{
	bool flag = false;
	flag = isInterleaving("AB", "CD", "ABCD");
	cout << flag<<endl;
	flag = isInterleaving("AB", "CD", "ACBD");
	cout << flag<<endl;
	flag = isInterleaving("ABC", "CD", "CABD");
	cout << flag<<endl;
	flag = isInterleaving("SAS", "RAM", "SRAMAS");
	cout << flag<<endl;
	getchar();
	return 0;
}

