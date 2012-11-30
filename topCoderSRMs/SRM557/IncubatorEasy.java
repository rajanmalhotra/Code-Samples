package topCoderSRMs.SRM557;

public class IncubatorEasy {
	
	public static int current = 0;
	
	public int maxMagicalGirls(String[] love){
		int girls = love.length;
		boolean isMagical[] = new boolean[girls];
		Boolean isProtected[] = new Boolean[girls];
		
		for(int i=0; i < girls; i++){
			isMagical[i] = false;
		}
		for(int i=0; i < girls; i++){
			isProtected[i] = false;
		}
		
		for(int i=0; i < girls; i++){
			if(!isMagical[i]){
				isMagical[i] = true;
				for(int j=0; j < girls; j++){
					char otherGirl = love[i].charAt(j);
					if(otherGirl=='Y'){
						isProtected[j] = true;
						current = j;
						turnProtected(j, isProtected, love);
					}
				}
			}
		}
		
		int count=0;
		for(int i=0; i < girls; i++){
			if(isMagical[i] && !isProtected[i]){
				count++;
			}
		}
		return count;
	}
	
	public void turnProtected(int girl, Boolean[] isProtected, String[] love){
		int girls = love.length;
		
		for(int k=0; k < girls; k++){
			if(current==girl){
				continue;
			}
			char anotherGirl = love[girl].charAt(k);
				if(anotherGirl=='Y' && k!=girl){
					isProtected[k] = true;
					current = k;
					turnProtected(k, isProtected, love);
			}							
		}
	}
	
	public static void main(String[] args){
		String[] love = {"NNNNN","NYNNN","NYNYN","YNYNN","NNNNN"};
					//{"NNNNN","NNNNN","NNNNN","NNNNN","NNNNN"};
		IncubatorEasy ie = new IncubatorEasy();
		System.out.println(ie.maxMagicalGirls(love));
	}
}
