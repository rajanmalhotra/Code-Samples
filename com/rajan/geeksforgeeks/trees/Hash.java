package com.rajan.geeksforgeeks.trees;

import java.util.*;

public class Hash<K,V> {
	private final int MAX_SIZE =10;
	LinkedList<Cell<K,V>>[] items;
	
	public Hash(){
		items = (LinkedList<Cell<K,V>>[]) new LinkedList[MAX_SIZE];
	}
	
}

class Cell<K,V>{
	K val;
	V val1;
}
