package com.rajan.designs;

public class Singleton {

	/* private static Singleton instance = new Singleton(); */
	private static Singleton instance=null;
	
	private Singleton(){
		
	}
	
	public static Singleton getInstance(){
		if(instance==null){
			synchronized(Singleton.class){
				if(instance==null){
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
}
