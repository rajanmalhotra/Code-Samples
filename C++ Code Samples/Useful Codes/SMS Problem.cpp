#include <iostream>
#include <vector>
#include <string>

using namespace std;

void makeSMS(string input){
	
	string chars[] = { "\0", "\0", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ", "* ", "#b"};
	vector<string> numdial;
	for(int i = 1; i < chars->length() ; i++)
		numdial.push_back(chars[i]);
	
	vector<int> output;
	for(int i =0 ; i < input.length(); i++){
		if(i==0)
			output.push_back(numdial[input[i]]);
		else if(i>0)
			if(input[i] && input[i]==input[i-1]
	}

}

int main(){
	makeSMS("222");
	getchar();
	return 0;
}