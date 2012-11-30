/*
Write an algorithm to print all ways of arranging eight queens on a chess board
so that none of them share the same row, column or diagonal.
*/
/*
this wil have x1 != x2 or y1 != y2 or x1-y1 != x2-y2
*/

#include <iostream>
#include <vector>

using namespace std;

typedef struct point{
	char x;
	char y;
}point;

bool check_crossing(vector<point> points, point b){
	for(int i=0; i < points.size(); i++){
		point a = points[i];
		if(a.x == b.x || a.y == b.y || (a.x-b.x)==(a.y-b.y)	|| (a.x-b.x)==(b.y-a.y))
			return true;
	}
	return false;
}

void placequeens(char chess[8][8], vector<point> points){
	for(int i=0; i < points.size(); i++)
		chess[points[i].x-1][points[i].y-1] = 'X';
}

vector<point> brute_force_place(vector<point> points){
	point new_p;
	for(int i=1; i <= 8; i++){		
		for(int j=1; j <= 8; j++){
			new_p.x = i;
			new_p.y = j;
			if(!check_crossing(points, new_p)){
					points.push_back(new_p);
					break;
			}			
		}
	}
	return points;
}

void printarr(char arr[8][8]){
	cout<<"Chess Board is : "<<endl;
	for(int i=0; i < 8; i++){
		for(int j=0; j<8; j++)
			cout<<arr[i][j]<<" ";
		cout<<endl;
	}
}


int colforRow[8] = {0};
char chess2[8][8] = {'.'};

bool check(int row){
	for(int i=0; i < row; i++){
		int diff = abs(colforRow[i] - colforRow[row]);
		if(diff == 0  || diff == (row - i))
			return false;
		/*if(row == i || colforRow[i] == colforRow[row] || 
			row-i == colforRow[row] - colforRow[i]	||
			row-i == colforRow[i] - colforRow[row])
			return false;*/
	}
	return true;
}

void placeQueen(int row){
	if(row==8){
		/*for(int i=0; i < 8; i++)
				chess2[i][colforRow[i]] = 'X';*/
		return;
	}
	for(int i=0; i < 8; i++){
		colforRow[row] = i;
		if(check(row))
			placeQueen(row+1);
	}
}

int main(){
	char chess[8][8] = {'.'};
	vector<point> points;
	point new_p;
	new_p.x = 1;
	new_p.y = 1;
	points.push_back(new_p);
	/* Method 1 - does not work */	
	points = brute_force_place(points);
	placequeens(chess, points);
	printarr(chess);
	
	/* Method 2 (BackTracking Algorithm) - works */
	placeQueen(0);
	for(int i=0; i < 8; i++)
		chess2[i][colforRow[i]] = 'X';
	printarr(chess2);
	getchar();
	return 0;
}