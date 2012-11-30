package topCoderSRMs.SRM557;

public class Permutations {

	public void doPermute(char[] str, StringBuffer out, boolean[] used, int level){
		if(level==str.length){
			System.out.println(out);
			return;
		}
		for(int i=0; i < str.length; i++){
			if(used[i]==true){
				continue;
			}
			out.append(str[i]);
			used[i] = true;
			doPermute(str, out, used, level+1);
			used[i] = false;
			out.setLength(out.length()-1);
			//out.deleteCharAt(out.length()-1);
			//out.subSequence(start, end)
			//out.replace(0, 1, "raj");
			//out.reverse();
			//out.indexOf("RAJAN");
			
		}
	}
	
	public void doPermute2(char[] str, StringBuffer out, int used, int level){
		if(level==str.length){
			System.out.println(out);
			return;
		}
		for(int i=0; i < str.length; i++){
			if(((used>>i) & 1) > 0){
				continue;
			}
			out.append(str[i]);
			used |= 1 << i;			
			doPermute2(str, out, used, level+1);
			used &= ~(1 << i);
			out.setLength(out.length()-1);
		}
	}
	
	public void permute(String str){
		int len = str.length();
		boolean used[] = new boolean[len];
		StringBuffer out = new StringBuffer();
		System.out.println("=========== Using Boolean Array ===========");
		doPermute(str.toCharArray(), out, used, 0);
		System.out.println("\n=========== Using an Integer Value ===========");
		doPermute2(str.toCharArray(), out, 0, 0);
	}
	
	public static void main(String[] args){
		Permutations p = new Permutations();
		p.permute("SHRA");
	}
}
