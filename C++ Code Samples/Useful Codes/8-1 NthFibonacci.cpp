#include <iostream>

using namespace std;

int fibonacci(int n){
	if(n==0)
		return 0;
	else if(n==1)
		return 1;
	else if(n > 1)
		return fibonacci(n-1) + fibonacci(n-2);
}

int fibonacci_Iter(int n){
	int val=1;
	int a=0, b=1, c;
	for(int i=2; i <= n; i++){
		c = a+b;//fibo[i] = fibo[i-1] + fibo[i-2];
		a = b;
		b = c;
	}
	return c;//fibo[n];
}

int main(){
	cout<<"Fibonacci of num is : "<<fibonacci(8)<<endl;
	cout<<"Fibonacci of num is : "<<fibonacci_Iter(8);
	getchar();
	return 0;
}