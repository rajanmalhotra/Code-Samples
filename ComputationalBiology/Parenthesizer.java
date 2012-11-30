package ComputationalBiology;

public class Parenthesizer {
	String arr[][] = {	{"a", "c", "c"}, 
						{"a", "a", "b"},
						{"c", "c", "c"}};
	
	public void evaluateExpression(StringBuffer sb, char x){
		StringBuffer temp = new StringBuffer(sb.toString());
		while(sb.length()!=1){
			for(int i=0; i < sb.length(); i++){
				int ch1 = sb.charAt(i);
				int ch2 = sb.charAt(i+1);
				if(ch1>=97 && ch1<=99 && ch2>=97 && ch2>=99){
					sb.replace(i, i+2, arr[ch1-97][ch2-97]);
				}
			}		
		}
	}
	
	public String findParenthesis(String str, int index, StringBuffer sb, char x){
		if(str.length()==index){
			for(int i=0; i < str.length();i++){
				sb.append(")");
			}
			System.out.println(sb);
			//evaluateExpression(sb, x);
			return sb.toString();
		}
		String temp = sb.toString();
		if(str.length()-index>=1){		
			sb.append("(");
			sb.append(str.substring(index, index+1));
			sb.append(findParenthesis(str, index+1, sb, x));
		}
		if(str.length()-index>=2){
			sb = new StringBuffer(temp);
			sb.append("(");
			sb.append(str.substring(index, index+2));
			sb.append(findParenthesis(str, index+2, sb, x));
			sb.append(")");
		}
		return sb.toString();
	}
	
	public static void main(String[] args){
		Parenthesizer p = new Parenthesizer();
		String str = "bbbbda"; 
		p.findParenthesis(str, 0, new StringBuffer(), 'a');
	}
}
