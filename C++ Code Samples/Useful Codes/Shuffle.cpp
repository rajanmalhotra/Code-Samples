#include<iostream>

using namespace std;

void shift(char str[], int i, int j)
{
	for(j; j>i; j--)	
		str[j] = str[j-1];			
}

void shuffle(char str[])
{
	int i, j;
	int len = strlen(str);
	char letter;
	if(len%2==1)
	{
		cout<<"This string cannot be shuffled because of odd len."<<endl;
		getchar();
		exit(0);
	}
	i = 1;
	j = len/2;
	while(i<j)
	{
		letter = str[j];
		shift(str, i, j);
		str[i]=letter;
		i += 2;
		j++;
	}
}

int main()
{
	char str[] = "123456789abcdefghi";
	shuffle(str);
	cout<<"Shuffled : "<<str<<endl;
	getchar();
	return 0;
}