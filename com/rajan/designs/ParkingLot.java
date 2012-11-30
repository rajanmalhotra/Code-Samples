package com.rajan.designs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class ParkingSpace{
	
}

class RegularSpace extends ParkingSpace{
	
}

class HandicappedSpace extends ParkingSpace{
	
}

public class ParkingLot {
	
	ParkingSpace[] space = new ParkingSpace[100];
	HashMap<Integer, Vehicle> parkedMap = new HashMap<Integer, Vehicle>();
	List<Integer> spaceAvailable = new ArrayList<Integer>();
	int countVacantSpace;
	private final static ParkingLot INSTANCE = new ParkingLot();
	private ParkingLot(){
		countVacantSpace = 100;
	}
	
	public boolean isFull(){
		return true;
	}
	
	public int getFreeSpace(){
		return 0;
	}
	
	public void parkVehicle(int index){
		// assign space from ArrayList to HashMap
	}
	
	public void unParkVehicle(int index){
		// release space from HashMap to ArrayList
	}
	
	public static void main(String[] args){
		Singleton s = Singleton.getInstance();
	}
}

class Vehicle{
	
}

class Car extends Vehicle{
	
}

class Truck extends Vehicle{
	
}