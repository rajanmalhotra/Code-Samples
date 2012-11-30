//<pre lang="" line="1" title="7 - Permutations_String" class="run-this">
#include <iostream>
#include <string>

using namespace std;

static int count = 0;

void doPermute(string instr, string outstr, int length, bool *used){
	if(outstr.length()==instr.length()){
		cout<<++count<<" : "<<outstr<<endl;
		return;
	}
	for(int i = 0; i < length; i++){
		if(used[i])
			continue;
		outstr.append(instr.substr( i, 1));
		used[i] = true;
		doPermute(instr, outstr, length, used);
		used[i] = false;
		outstr.erase(outstr.length()-1);		
	}
}

int main(){
	string str = "RAJN";
	string outstr;
	bool *used = new bool[str.length()];
	for(int i=0; i < str.length(); i++)
		used[i] = false;
	doPermute(str, outstr, str.length(), used);
	getchar();
	return 0;
}

//</pre>
//<pre title="7 - Permutations_String.cpp" input="yes"></pre>