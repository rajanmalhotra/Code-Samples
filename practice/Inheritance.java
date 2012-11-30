package practice;

class Animal {
	public Animal(){
		System.out.println("Animal");
	}
	public Animal(int a){
		System.out.println("Animal Int");
	}
}

class Horse extends Animal{
	public Horse(){
		super(1);
		System.out.println("Horse"); 	
	}
}

public class Inheritance{

	public static void main(String[] args){
		Animal a = new Animal();
		Horse h = new Horse();
	}
}

class Single{
	public static Single instance;
	public static Single get(){
		if(instance==null){
			instance = new Single();
		}
		return instance;
	}
}