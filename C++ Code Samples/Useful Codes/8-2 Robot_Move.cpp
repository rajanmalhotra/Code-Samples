#include <iostream>
#include <vector>

using namespace std;

static int count = 0;

typedef struct point{
	int x;
	int y;
}point;

vector<point*> myvector;

void printvector()
{
	for(int i=0; i < myvector.size(); i++)
		cout<<myvector[i]->x<<", "<<myvector[i]->y<<" -> ";
	cout<<"Done"<<endl;
}
/* x,y denotes the starting position of the robot */
void robot_move(int x, int y, int n){
	
	point *p = (point*)malloc(sizeof(point));
	p->x = x;
	p->y = y;
	
	myvector.push_back(p);

	if(x==n && y==n){
		printvector();
		count++;
		myvector.pop_back();
		return; 
	}

	if(x==n){
		robot_move(x, y+1, n);
	}
	if(y==n){
		robot_move(x+1, y, n);
	}
	if(x<n && y<n){
		robot_move(x+1, y, n);
		robot_move(x, y+1, n);
	}
	myvector.pop_back();
}

int main(){
	robot_move(1, 1, 5);
	cout<<"Total Paths are : "<<count<<endl;
	getchar();
	return 0;
}