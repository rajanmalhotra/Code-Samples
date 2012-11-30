#include <iostream>
#include <vector>
#include <string>

using namespace std;

void doCombine(string instr, string outstr, int length, int start){
	for(int i = start; i < length; i++){
		string end = instr.substr(i, 1);
		outstr.append(end);
		cout<<outstr<<endl;
		if( i < length - 1 ){
			doCombine(instr, outstr, length, i + 1 );
		}
		outstr.erase(outstr.length()-1, 1);		
	}
}

int main(){
	string str = "RAJN";
	string outstr;
	doCombine(str, outstr, str.length(), 0);
	getchar();
	return 0;
}