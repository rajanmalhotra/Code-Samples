#include <iostream>

using namespace std;

void replacewith20_nospace(char *str)
{
	int i=0, len, newlen, j=0, spaces=0;
	while(str[i]!='\0')
	{
		if(str[i]==' ')
			spaces++;
		i++;
	}
	len = i;
	newlen = len + spaces*2;
	str[newlen] = '\0';
	cout<<"Len and Newlen : "<<len<<" "<<newlen;
	i=len-1;
	j=newlen-1;
	while(i > 0)
	{
		if(str[i]!=' ')
			str[j--] = str[i--];
		else
		{
			str[j--] = '0';
			str[j--] = '2';
			str[j--] = '%';
			i--;
		}
	}
}

char *replacewith20_space(char *str)
{
	int i=0, spaces = 0, len;
	char *ret = NULL;

	while(str[i]!='\0')
	{	
		if(str[i]==' ')
			spaces++;
		i++;
	}

	len = spaces*2 + i;
	ret = (char*)(malloc(sizeof(char)*len));
	ret[len] = '\0';
	i = 0;
	cout<<"Len : "<<len<<endl;
	while(ret[i] != '\0')
	{
		if(*str!=' ')
			ret[i++] = *str++;
		else
		{
			ret[i++] = '%';
			ret[i++] = '2';
			ret[i++] = '0';
			str++;
		}
	}
	return ret;
}

int main()
{
	char *ret;
	char str[] = "Please replace my spaces with %20";
	cout<<"Before : "<<str<<endl;
	ret = replacewith20_space(str);
	cout<<"After  : "<<ret<<endl;
	//replacewith20_nospace(str);
	//cout<<"Str now: "<<str<<endl;
	getchar();
	return 0;
}