#include <iostream>
#include <vector>

using namespace std;

vector<vector<int>> getSubsets(vector<int> set, int index)
{
	vector<vector<int>> allSubsets;
	vector<int> newSubset;
	
	if(set.size()==index){
		allSubsets.push_back(newSubset);
	}
	else{
		int item = set.at(index);
		allSubsets = getSubsets(set, index + 1);		
		vector<vector<int>> moreSubsets;
		for(int i=0; i < allSubsets.size(); i++){
			newSubset.clear();
			newSubset.insert(newSubset.end(), allSubsets[i].begin(), allSubsets[i].end());
			newSubset.push_back(item);
			moreSubsets.push_back(newSubset);
		}
		allSubsets.insert(allSubsets.end(), moreSubsets.begin(), moreSubsets.end());
	}
	return allSubsets;
}

vector<vector<int>> getSubsets_combi(vector<int> set)
{
	vector<vector<int>> allSubsets;
	vector<int> newSubset;
	int max = 1 << set.size();
	for(int i=0; i < max; i++){
		newSubset.clear();
		int k = i;
		int index = 0;
		while(k > 0){
			if((k&1) > 0)
				newSubset.push_back(set.at(index));
			k = k >> 1;
			index++;
		}
		allSubsets.push_back(newSubset);
	}
	return allSubsets;
}

void printvector(vector<vector<int>> myvector){
	for(int i=0; i < myvector.size(); i++){
		cout<<"Set No : "<<i<<" == ";
		for(int j=0; j <myvector[i].size(); j++)
			cout<<myvector[i][j]<<" ";
		cout<<endl;
	}
}

vector<vector<int>> getSubsets2(vector<int> set){
	int k, index;
	int max = 1 << set.size();
	vector<vector<int>> allSubsets;
	for(int i = 0; i < max; i++){
		vector<int> newSubset;
		k = i;
		index = 0;
		while(k > 0){
			if((k&1) > 0)
				newSubset.push_back(set.at(index));	
			k = k >> 1;
			index++;
		}
		allSubsets.push_back(newSubset);
	}
	return allSubsets;
}

int main(){
	int dim = 6;
	int arr[] = {2, 4, 7, 10, 6, 12};
	vector<int> numbers;
	for(int i=0; i < dim; i++)
		numbers.push_back(arr[i]);
	vector<vector<int>> myvector;
	myvector = getSubsets(numbers, 0);
	printvector(myvector);

	/* Combinatorics subSets */
	myvector.clear();
	myvector = getSubsets2(numbers);
	printvector(myvector);

	getchar();
	return 0;
}