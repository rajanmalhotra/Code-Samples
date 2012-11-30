package topCoderSRMs.SRM557;

public class GreatFairyWar {
	
	public int minHP(int[] dps, int[] hp){
		int len = dps.length;	
		int hits = 0;
		
		for(int i=0; i < len; i++){
			for(int j=i; j < len; j++){
				hits += hp[i]*dps[j];
			}			
		}
		return hits;
	}
	
	public static void main(String[] args){
		int[] hp = {2,27,18,19,14,8,25,13,21,30};
		int[] dps = {30,2,7,4,7,8,21,14,19,12};
		GreatFairyWar g = new GreatFairyWar();
		System.out.println(g.minHP(dps, hp));
	}
}
