#include <iostream>

using namespace std;

void reverse(char *str)
{
	char temp;
	char *end = str;
	while(*end != NULL)
		end++;
	end--;

	while(str < end)
	{
		temp = *str;
		*str++ = *end;
		*end-- = temp;
	}
}

int main()
{
	char str[] = "Reverse Me";
	int i;
	char temp;
	int len = strlen(str);
	for(i=0; i < len/2; i++)
	{
		temp = str[i];
		str[i] = str[len-i-1];
		str[len-i-1] = temp;
	}
	cout<<str<<endl;

	reverse(str);
	cout<<"Reversed again : "<<str;

	getchar();
	return 0;
}