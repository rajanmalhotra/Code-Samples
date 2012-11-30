/*
Implement an algorithm to print all valid (e.g., properly opened and closed) combinations of n-pairs of parentheses.
EXAMPLE:
input: 3 (e.g., 3 pairs of parentheses)
output: ()()(), ()(()), (())(), ((()))
*/

#include <iostream>

using namespace std;

void printpar(int l, int r, char *str, int count){
	/* invalid state */
	if(l < 0 || r < l)
		return;
	/* found one, as l and r are finished */
	if(l==0 && r==0)
		cout<<str<<endl;
	else{
		/* try a left paren, if there are some available */
		if(l > 0){
			str[count] = '(';
			printpar(l-1, r, str, count + 1);
		}
		/* try a right paren, if its left has been used */
		if(r > l){
			str[count] = ')';
			printpar(l, r-1, str, count+1);
		}
	}
}

int main()
{
	int count = 4; /* Pairs of parenthesis */
	char str[9]={'\0'};	
	printpar(count, count, str, 0);
	getchar();
	return 0;
}