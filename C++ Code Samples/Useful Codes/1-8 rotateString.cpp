#include <iostream>

using namespace std;

bool isRotation(char *str2, char *str1)
{
	int len1 = strlen(str1);
	int len2 = strlen(str2);
	char *str = NULL;
	if(len1!=len2)
		return false;
	str = (char*)(malloc(sizeof(char)*(2*len2)));
	strcpy(str, str1);
	strcat(str, str1);
	cout<<str<<endl;
	str = strstr(str, str2);
	if(str != NULL)
		return true;
	else
		return false;
}

int main()
{
	bool ret;
	char str1[] = "rajan malhotra";//"waterbottle";
	char str2[] = "malhotrarajan ";//"erbottlewat";
	ret = isRotation(str1, str2);
	cout<<"Is "<<str1<<" Rotation of "<<str2<<" : "<<ret;
	getchar();
	return 0;
}