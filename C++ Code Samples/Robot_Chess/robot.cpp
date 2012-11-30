#include<stdio.h>
#define SIZE 5

int count = 0;
void travel (int i , int j);

int main()
{
	travel(1,1);		
}

void travel (int i , int j)
{
	
 /*       if( i>SIZE && j >SIZE )
		return;*/
	printf("At %d %d\n",i,j);
    if(i==SIZE && j == SIZE )
	{		
		printf("Yuppi I am done");
		count++;
		return;
	}
	if(i==SIZE)
	  {
		travel(i,j+1);
		return;
	  }
	if(j==SIZE)
	{
		travel(i+1,j);
		return;
	}

	travel(i,j+1);
	travel(i+1,j);
	return;
}
