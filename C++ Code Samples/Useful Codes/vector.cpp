#include <iostream>
#include <vector>

using namespace std;

int main()
{
	// 10 zero initialized ints
	vector<int> myvec (3,100);
	vector<int>::iterator it;
	unsigned int i;
	int myarray [] = { 501,502,503 };

	//cout<<"Working on Vectors"<<endl;

	////assign values
	//for(i =0; i<myvec.size(); i++)
	//	myvec.at(i) = i;

	//cout << "myvector contains:";
	//for (i=0; i<myvec.size(); i++)
	//	cout << " " << myvec.at(i);
	//cout<<endl;
	//
	//for ( it=myvec.begin() ; it < myvec.end(); it++ )
	//	cout << " " << *it;
	//cout<<endl;

	//cout<<"Size : "<<myvec.size()<<endl;
	//cout<<"Capacity : "<<myvec.capacity()<<endl;

	it = myvec.begin();
	it = myvec.insert( it , 200 );
	myvec.insert( it, 2, 300);
	for ( it=myvec.begin() ; it < myvec.end(); it++ )
		cout << " " << *it;
	
	// "it" no longer valid, get a new one:
	it = myvec.begin();
	vector<int> anothervector ( 2, 400);
	myvec.insert (it+2, anothervector.begin(), anothervector.end());
	myvec.insert (myvec.begin(), myarray, myarray+3);
	
	cout << "myvector contains:";
	for (it=myvec.begin(); it<myvec.end(); it++)
		cout << " " << *it;
	cout << endl;

	getchar();
	return 0;
}