#include <iostream>
#include <vector>

using namespace std;

bool checkAnagrams(char *str1, char *str2)
{
	vector<int> vec(256);
	int i;
	for(i=0; i< 256; i++)
		vec[i] = 0;

	if(strlen(str1)!=strlen(str2))
		return false;

	i=0;
	while(str1[i]!= '\0')
		vec[str1[i++]]++;
	
	i=0;
	while(str2[i]!= '\0')
	{
		vec[str2[i]]--;
		if(vec[str2[i++]]<0)
			return false;
	}
	return true;
}

int main()
{
	char str1[] = "I AMLORD VOLDEMORT";
	char str2[] = "TOM MARVOLO RIDDLE";
	bool val;

	val = checkAnagrams(str1, str2);
	cout<<"Are these anagrams? "<<val;

	getchar();
	return 0;
}