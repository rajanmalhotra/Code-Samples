#include <iostream>

using namespace std;

void removeduplicates(char *str)
{
	char *end = str;
	int len = strlen(str);
	int i, j, tail;

	tail = 1;
	for(i=1; i < len; i++)
	{
		for(j=0; j < tail; j++)
			if(str[i] == str[j])
				break;
		if(j==tail)
		{
			str[tail] = str[i];
			tail++;
		}
	}
	str[tail] = '\0';
}

int main()
{
	char str[] = "Remove duplicates from me";
	cout<<"Original : "<<str<<endl;
	removeduplicates(str);
	cout<<"Duplicates removed  : "<<str<<endl;
	getchar();
	return 0;
}
