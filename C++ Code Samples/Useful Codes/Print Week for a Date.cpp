#include <iostream>
#include <string>
#include <vector>

using namespace std;

const int NUMBEROFDAYS[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};
enum days {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY};

bool isLeapYear(int year){
	return (year%400 == 0)||(year%4 == 0 && year%100 != 0);
}

int numberOfDaysInMonthAndYear(int month, int year){ 
	if(isLeapYear(year) && month == 2){
		return 29;    
	}
	else return NUMBEROFDAYS[month];
}

void printDay(int day, int month, int year, int whichDay){
	cout<<day<<", "<<month<<", "<<year<<" is "<<whichDay<<endl;
}

void findWeek(int day, int month, int year, int whichDay){  
	for( int i = whichDay ; i > 0 ; --i){
		if(day == 1){
			if(month == 1){
				year--;  
				month = 12;
				day = numberOfDaysInMonthAndYear(month, year);    
			}
			else {
				month--;     
				day = numberOfDaysInMonthAndYear(month, year);    
			}
		}
		else day--;  
	}
	
	for(int i = 0; i < 7 ; ++ i){
		printDay(day, month, year, i);   
		day++;   
		if(day > numberOfDaysInMonthAndYear(month, year)){
			day = 1;     
			month++;    
			if(month > 12){
				month = 1;  
				year++;     
			}
		}
	}
}

int main (int argc, const char * argv[]){
	findWeek( 1, 2 , 2001, 3); 
	getchar();
	return 0;
}