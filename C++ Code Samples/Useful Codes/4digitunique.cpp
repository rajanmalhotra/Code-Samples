#include <iostream>

using namespace std;

char* convertintoCharArray(int num){
	char char_num[4] = {0};
	int i = 3;
	while(num!=0){
		char_num[i--] = num%10;
		num = num/10;	
	}
	return char_num;
}

int main(){
	char* temp = NULL;
	bool flag;
	for(int i =1000; i < 9999; i++){
		flag = true;
		temp = convertintoCharArray(i);
		
		if(temp[0]==4 && temp[3]==4)
			flag = false;

		for(int j=0; j < 3; j++){
			if(temp[j] == temp[j+1])
				flag = false;
		}

		if(flag)
			cout<<i<<" ";
	}
	getchar();
	return 0;
}