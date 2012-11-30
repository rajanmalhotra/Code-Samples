//#include <iostream>
//#include <cstring>
//#include <malloc.h>
//
//using namespace std;
//
//void swapchars(char* a, char* b)
//{
//	char letter = *a;
//	*a = *b;
//	*b = letter;
//}
//
//void swapnotemp(char* a, char* b)
//{
//	*a = *a ^ *b;
//	*b = *a ^ *b;
//	*a = *a ^ *b;
//}
//
//char* reversestr(char str[])
//{
//	int i=0;
//	int len = strlen(str);
//
//	for(i=0; i<len/2; i++)
//	{
//		swapchars(&str[i], &str[len-i-1]);
//		swapnotemp(&str[i], &str[len-i-1]);
//		swapchars(&str[i], &str[len-i-1]);
//	
//	}
//	return str;
//}
//
//char* reversewords(char str[])
//{
//	int i=0, j=0, chars;
//	int len = strlen(str);
//	char* rev = new char[len+1];
//	
//	for(i=len-1; i>=0; i--)
//	{
//		if(str[i] == ' ' || i==0)
//		{
//			if(i==0)
//			{
//				i=-1;
//				j++;
//			}
//			chars = 0;
//			for(j; j>0; j--)
//			{
//				rev[len-1-i-j] = str[i+1+chars];
//				chars++;
//			}
//			if(i==-1)
//				rev[len-1-i-j] = str[i+1+chars];
//			else
//				rev[len-1-i-j] = ' ';
//			j=-1;
//		}	
//		j++;
//	}
//	rev[len] = '\0';
//	return rev;
//}
//
//int main()
//{
//    char str[] = "India vs Pakistan semi final match was fixed : says a bookie"; 
//	int i, len;
//    char* rev;
//	cout<<"Original String : ";
//    cout<<str<<endl;
//    cout<<"Reversed String : ";
//	cout<<reversestr(str)<<endl;
//	strcpy(str, "India vs Pakistan semi final match was fixed : says a bookie"); 
//	cout<<"Reversed Words  : ";
//	rev = reversewords(str);
//	cout<<rev<<endl;
//	delete[] rev;
//	getchar();
//	return 0;
//}
//
