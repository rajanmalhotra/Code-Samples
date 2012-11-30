#include <iostream>
#include <vector>
#include <string.h>

using namespace std;

class PlatypusPaternity{
public:
	int maxFamily(vector <string> femaleCompatibility, vector <string> maleCompatibility, vector <string> siblingGroups);
};

int PlatypusPaternity::maxFamily(vector <string> femaleCompatibility, vector <string> maleCompatibility, vector <string> siblingGroups)
{
	unsigned int i,j,k, l;
	int val = 0;
	int count = 0;
	for(i=0; i < femaleCompatibility.size(); i++){		
		for(j=0; j < femaleCompatibility[i].size(); j++){			
			if(femaleCompatibility[i].at(j)=='Y' && maleCompatibility[i].at(j)=='Y'){
				for(l=0; l < siblingGroups.size(); l++){
					count = 0;
					for(k=0; k < siblingGroups[l].size();k++)
						if(siblingGroups[l].at(k)=='Y')	
							count++;
					count += 2;
					if(count > val)
						val = count;
				}
			}
		}
	}
	return val;
}

int main()
{
	vector<string> f, m, s, f1,m1,s1;
	
	f.push_back("YYYYYYYYN");
	//f.push_back("YYNNN");
	m.push_back("YYYYYYYYY");
	//m.push_back("YYYN");
	s.push_back("YNYNYNYNY");
	s.push_back("NNNYNYNNN");
	s.push_back("NYNNNNNYN");
	PlatypusPaternity c;
	int val = c.maxFamily(f, m, s);
	cout<<"Val is : "<<val;
	
	f1.push_back("YYYY");
	f1.push_back("YYYY");
	m1.push_back("NNYN");
	m1.push_back("YYYN");
	s1.push_back("YYYN");
	s1.push_back("NNYY");
	val = c.maxFamily(f1, m1, s1);	
	cout<<"Val is : "<<val;
	getchar();
	return 0;
}

