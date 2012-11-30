#include <iostream>
#include <vector>
#include <string>

using namespace std;

/*
Let us assume a given string S represents the letters A1, A2, A3... An
To permute the set S, we can select the first char, A1, and permute the remainder of the string to get a new list.
Then with this new list, we push 'A1' into each possible position.
*/
	
string insertCharAt(string word, char c, int i) {
	string start = word.substr(0, i);
	string end = word.substr(i);
	start.append(&c);
	start.append(end);
	return start;
}

// At each level, we return vector of permutations of strings possible using those
// characters coming in a string (as a remainder)
vector<string> permute_string(string str){
	vector<string> permutations;
	if(str.length()==0){
		//base case
		permutations.push_back("");
		return permutations;
	}

	char first = str.at(0);
	string remainder = str.substr(1);
	vector<string> words = permute_string(remainder);
	for(int i=0; i < words.size(); i++)
		for(int j=0; j<=words[i].length(); j++){
			string perm = insertCharAt(words[i], first, j);
			permutations.push_back(perm);
		}
	return permutations;
}

int main(){
	string str = "RAJN";
	vector<string> permutations;
	permutations = permute_string(str);
	for(int i=0; i < permutations.size(); i++){
		cout<<permutations[i]<<endl;		
	}
	getchar();
	return 0;
}