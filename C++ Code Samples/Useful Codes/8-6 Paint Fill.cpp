/*
Implement the �paint fill� function that one might see on many image editing programs.
That is, given a screen (represented by a 2 dimensional array of Colors), a point, and a new color,   
fill in the surrounding area until you hit a border of that color.
*/

#include <iostream>

using namespace std;

void paintfill(int screen[7][7], int x, int y, int new_color){
	
	if(x<0 || y>=7 || x>=7 || y<0)// || screen[x][y]!=0)	
		return;
	if(screen[x][y]==0 || screen[x][y]==1){
		screen[x][y] = new_color;
		paintfill(screen, x+1, y, new_color);
		paintfill(screen, x, y+1, new_color);
		paintfill(screen, x-1, y, new_color);
		paintfill(screen, x, y-1, new_color);
	}	
	return;
}

void printscreen(int screen[7][7])
{
	for(int i=0; i < 7; i++){
		for(int j=0; j < 7; j++)
			cout<<screen[i][j]<<" ";
		cout<<endl;
	}
}

int main(){
	int screen[7][7] = {
		1, 1, 1, 1, 1, 1, 1,
		1, 0, 0, 0, 0, 0, 1,
		1, 0, 0, 0, 0, 0, 1,
		1, 0, 0, 0, 0, 0, 1,
		1, 0, 0, 0, 0, 0, 1,
		1, 0, 0, 0, 0, 0, 1,
		1, 1, 1, 1, 1, 1, 1
	};

	int x, y;
	x = 4;
	y = 4;

	cout<<"Before Painting :"<<endl;
	printscreen(screen);	
	/* passing screen, point and new_color */
	paintfill(screen, x, y, 2);
	cout<<endl<<"After Painting :"<<endl;
	printscreen(screen);	
	getchar();
	return 0;
}