/*
Write a function to reverse the vowels of a string (vowels are a, e, i, o, u) in place. In other words, the same memory that the string is stored in is used as both input and output:
 
Examples:
"deadbeef" becomes "deedbaef"
"Mad cow disease" becomes "Med caw desiosa"

Please document any assumptions you are making, you can make any reasonable assumptions considering the amount of time you have.
*/

#include<stdio.h>
#include<stdlib.h>
#include<string.h>

/* check if the character is vowel or not in both upper and lower cases */
int isVowel(char* str){
	char temp = *str;
	if(temp >=65 && temp <=90){
		temp +=32;
	}

	if(temp=='a' || temp=='e' || temp=='i' || temp=='o' || temp=='u'){
		return 1;	
	}else{
		return 0;	
	}
}

/* main function */
int main(int argc, char** argv){

	char* str = NULL;
	int i=0; 
	int j=0;
	int len=0;
	if(argc!=2){
		printf("usage: ./program <Input String>\n");			
		return -1;
	}
	len = strlen(argv[1]);
	str = (char*)malloc(len);
	memcpy(str, argv[1], len);

	/* printing the string*/
	printf("Length of String: %d\n",len);
	printf("Original String : ");
	for(i=0; i < len; i++){
		printf("%c",str[i]);
	}
	printf("\n");

	/* reversing vowels */
	i=0; j=len;
	while(i<j){
		while(i<j && !isVowel(str+i)){
			i++;
		}
		while(i<j && !isVowel(str+j)){
			j--;
		}
		/* swap character values */
		if(i<j){
			str[i] = str[i] ^ str[j];
			str[j] = str[i] ^ str[j];
			str[i] = str[i] ^ str[j];
		}else{
			break;
		}
		i++;
		j--;
	}
	printf("Vowels Swapped  : ");
	puts(str);
	if(str){
		free(str);
	}
	return 0;
}
