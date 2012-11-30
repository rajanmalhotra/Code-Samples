package practice;

public class MatchPatterns {
	
	public static boolean matchPattern(String test, String glob){
		if(test.equals("") && glob.equals("")){
			return true;
		}else if((!test.equals("") && glob.equals("")) || (test.equals("") && !glob.equals(""))){
			return false;
		}
		
		if(glob.equals("")){
			return true;
		}
		boolean success = false;
		if(glob.charAt(0)=='a'){
			if(test.charAt(0)!='a'){
				return false;
			}
			return matchPattern(test.substring(1), glob.substring(1));
		}else if(glob.charAt(0)=='b'){
			if(test.charAt(0)!='b'){
				return false;
			}
			return matchPattern(test.substring(1), glob.substring(1));
		}else if(glob.charAt(0)=='?'){
			if(test.charAt(0)=='a'){
				success = matchPattern(test.substring(1), glob.substring(1));
			}
			if(!success && test.charAt(0)=='b'){
				success = matchPattern(test.substring(1), glob.substring(1));
			}
			return success;
		}else if(glob.charAt(0)=='*'){
			for(int k=0; k < test.length(); k++){
				success = matchPattern(test.substring(k+1), glob.substring(1));
				if(success){
					return true;
				}
			}
			return false;
		}
		return success;
	}
	
	public static void main(String[] args){
		String test= "abbaabbbbba";
		String glob = "a?b*abb*ba";
		System.out.println(matchPattern(test, glob));
	}
}
