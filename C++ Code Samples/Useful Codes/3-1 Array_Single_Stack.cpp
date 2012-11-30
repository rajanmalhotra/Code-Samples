/*
Describe how you could use a single array to implement three stacks.

Divide the array in three equal parts and allow the individual stack to grow in that limited space.
(note: �[� means inclusive, while �(� means exclusive of the end point).
��for stack 1, we will use [0, n/3)
��for stack 2, we will use [n/3, 2n/3)
��for stack 3, we will use [2n/3, n)
This solution is based on the assumption that we do not have any extra information about the usage
of space by individual stacks and that we can�t either modify or use any extra space. 
With these constraints, we are left with no other choice but to divide equally.
1 int stackSize = 300;
2 int[] buffer = new int [stackSize * 3];
3 int[] stackPointer = {0, 0, 0}; // stack pointers to track top elem
4
5 void push(int stackNum, int value) {
6 /* Find the index of the top element in the array + 1, and
7 * increment the stack pointer */
/*
8 int index = stackNum * stackSize + stackPointer[stackNum] + 1;
9 stackPointer[stackNum]++;
10 buffer[index] = value;
11 }
12
13 int pop(int stackNum) {
14 int index = stackNum * stackSize + stackPointer[stackNum];
15 stackPointer[stackNum]--;
16 int value = buffer[index];
17 buffer[index]=0;
18 return value;
19 }
20
21 int peek(int stackNum) {
22 int index = stackNum * stackSize + stackPointer[stackNum];
23 return buffer[index];
24 }
25
26 boolean isEmpty(int stackNum) {
27 return stackPointer[stackNum] == stackNum*stackSize;
28 }
*/
#include <iostream>

using namespace std;

int main(){
}