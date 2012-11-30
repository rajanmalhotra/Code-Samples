package companies.Amazon;

class List{
	String value;
	List next;
	
	public List(){
		value = null;
		next = null;
	}
}

public class Hashtable {
	int size;		/* size of the table */
	List[] table;	/* table elements */
	
	public Hashtable(){
		this(10);		//default capacity
	}
	
	public Hashtable(int capacity){
		table = new List[capacity];
		for(int i=0; i < capacity; i++){
			table[i] = new List();
		}
		size = capacity;
	}
	
	/* compute hash */
	public int hash(String str){
		int hashValue = 0;
		for(int i=0; i < str.length(); i++){
			hashValue = str.charAt(i) + (hashValue << 2) - hashValue;
			hashValue = hashValue % Integer.MAX_VALUE;
			int x = 2 ^ 3;
			x = (int)Math.pow(2, 3);
		}
		return hashValue % size; 
	}
	
	/* lookup for this string */
	public List lookUp(String str){
		int hashValue = hash(str);
		List currentList = table[hashValue];
		while(currentList!=null){
			if(str.equals(currentList.value)){ 
	        	return currentList;
	        }
			currentList = currentList.next;
		}
		return null;
	}
	
	/* insert a string */
	public int addString(String str){
		List newList = new List();
		int hashValue = hash(str);
		
		/* check, if it exists? */
		List currentList = lookUp(str);
		if(currentList!=null){
			return 2;
		}
		
		/* insert into list */
		newList.value=str;
		newList.next = table[hashValue];
		table[hashValue] = newList;
		return 0;
	}
	
	/* remove a string */
	public boolean removeString(String str){
		int hashValue = hash(str);
		List currentList = table[hashValue];
		if(currentList!=null){
			if(currentList.value.equals(str)){
				table[hashValue] = currentList.next;
				return true;
			}
			while(currentList.next!=null){
				if(currentList.next.value.equals(str)){
					currentList.next = currentList.next.next;
					return true;
				}
				currentList = currentList.next;
			}
		}
		return false;
	}
	
	public static void main(String[] args){
		Hashtable table = new Hashtable(10);
		System.out.println("=========== Words for Insertion ===========");
		String[] words = {"Computer", "Science", "Engineering", "Branch", "Stony",
							"Brook", "University", "is", "a", "great", "Algorithms",
							"Computational", "Biology", "Network", "Programming", 
							"Operating", "Systems", "Wireless", "Databases", "ROPA"};
		for(String word : words){
			table.addString(word);
		}
		
		System.out.println("=========== Words for LookUp ===========");
		String[] wordsForLookUp = {"Brook", "University", "is", "a", "great", "Algorithms"};
		for(String word: wordsForLookUp){
			if(table.lookUp(word)==null){
				System.out.println(word + " is not found");
			}else{
				System.out.println(word + " is found");
			}
		}
		
		System.out.println("=========== Words for Deletion ===========");
		String[] wordsForDeletion = {"Computational", "Biology", "Network", "Programming"};
		for(String word : wordsForDeletion){
			if(table.removeString(word)==true){
				System.out.println(word + " is deleted");
			}else{
				System.out.println(word + " is not found for deletion");
			}
		}
		
		System.out.println("=========== Words for LookUp ===========");
		String[] lookUpWords = {"Computational", "Biology", "Network", "Programming"};
		for(String word : lookUpWords){
			if(table.lookUp(word)==null){
				System.out.println(word + " is not found");
			}else{
				System.out.println(word + " is found");
			}
		}
	}
}

