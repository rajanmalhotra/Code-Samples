#include <iostream>
#include <map>

using namespace std;


int main()
{
	map<int, int> mymap;
	map<int, int>::iterator it;
	pair<map<int, int>::iterator,bool> ret;

	mymap[0] = 3;
	mymap[1] = 5;
	mymap[2] = 10;
	mymap[3] = 45;
	mymap[4] = 33;
	mymap[5] = 56;
	mymap[6] = 34;
	mymap[7] = 15;
	mymap[8] = 89;
	mymap[9] = 65;

	cout<<mymap[0]<<" "<<mymap[1]<<" "<<mymap[2]<<endl;
		
	for(it=mymap.begin(); it!=mymap.end(); it++)
	{
		cout<<(*it).first<<" => "<<(*it).second<<endl;
	}

	it = mymap.find(4);
	mymap.erase(it);
	
	// first insert function version (single parameter)
	// inserting values using pair of int, int
	ret = mymap.insert ( pair<int, int>(10,100) );
	if(ret.second == true)
	{	
		cout<<"Element with index 10 inserted"<<endl;
	}
	ret = mymap.insert ( pair<int, int>(10,200) );
	if(ret.second == false)
	{	
		cout<<"Element with index 10 exists"<<endl;
	}
	cout<<"Sample : "<<mymap.find(5)->second<<endl;

	for(it=mymap.begin(); it!=mymap.end(); it++)
	{
		cout<<(*it).first<<" => "<<(*it).second<<endl;
	}
		  
	cout<<"Pair insert : "<<mymap[10]<<endl;
	getchar();
	return 0;
}