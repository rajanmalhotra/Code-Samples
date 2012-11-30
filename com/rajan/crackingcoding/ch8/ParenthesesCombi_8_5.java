/*Left: As long as we haven’t used up all the left parentheses, we can always insert a left
 paren.
»» Right: We can insert a right paren as long as it won’t lead to a syntax error. When will we
      get a syntax error? We will get a syntax error if there are more right parentheses than
     left.
So, we simply keep track of the number of left and right parentheses allowed. If there are
left parens remaining, we’ll insert a left paren and recurse. If there are more right parens
remaining than left (eg, if there are more left parens used), then we’ll insert a right paren and
recurse
*/

package com.rajan.crackingcoding.ch8;

public class ParenthesesCombi_8_5{

	public void parenthesesCombination(int l, int r, char[] str, int count){
		if(l<0 || r<l){	/* invalid state */
			return;		
		}
		if(l==0 && r==0){	/* found one str */
			System.out.println(str);		
		}else{
			if(l > 0){	/* try a left parentheses */
				str[count] = '(';
				parenthesesCombination(l-1, r, str, count+1);
			}
			if(r > l){	/* try a right parentheses */
				str[count] = ')';
				parenthesesCombination(l, r-1, str, count+1);
			}
		}		
	}

	public static void main(String[] args){
		int count = 4;
		char[] str = new char[count*2];
		ParenthesesCombi_8_5 par = new ParenthesesCombi_8_5();
		par.parenthesesCombination(count, count, str, 0);
	}
}

