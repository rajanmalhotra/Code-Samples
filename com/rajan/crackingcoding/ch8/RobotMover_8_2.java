package com.rajan.crackingcoding.ch8;

import java.util.ArrayList;
import java.lang.Math;

class Point{
	int x;
	int y;
	
	public Point(int row, int col){
		x = row;
		y = col;	
	}
}

public class RobotMover_8_2{
	private int N;
	private static int pathNum;
	private ArrayList<Point> list;
	private ArrayList<Point> blockedPoints;

	public RobotMover_8_2(int size){
		N = size;
		list = new ArrayList<Point>();
		pathNum = 0;
		blockedPoints = new ArrayList<Point>();
		System.out.println("List of Blocked Points : ");
		for(int i=2; i < N; i++){
			for(int j=2; j < N; j++){
				double rand = Math.random();
				if(rand >= 0.6){
					blockedPoints.add(new Point(i, j));
					System.out.print(i + "," + j + " ");
				}
			}		
		}
		System.out.println("\n------------------------------");
	}

	private void printPath(){
		for(int i=0; i < list.size(); i++){
			Point p = list.get(i);
			System.out.print(p.x + "," + p.y + " -> ");
		}
		System.out.println();
	}

	private boolean isBlocked(int row, int col){
		for(int i=0; i < blockedPoints.size(); i++){
			Point p = blockedPoints.get(i);
			if(p.x == row && p.y == col){
				return true;			
			}
		}
		return false;
	}

	public void moveRobot(int row, int col){
		list.add(new Point(row, col));
		if(isBlocked(row, col)){
			System.out.println("You are blocked at : " + row + " " + col);
			return;
		}

		if(row==N && col==N){
			pathNum++;
			System.out.print(pathNum + " : ");
			printPath();
			return;
		}

		if(row!=N){
			moveRobot(row+1, col);
			list.remove(list.size()-1);
		}
		if(col!=N){
			moveRobot(row, col+1);
			list.remove(list.size()-1);
		}	
	}

	public static void main(String[] args){
		RobotMover_8_2 robot = new RobotMover_8_2(4);
		robot.moveRobot(1, 1);		
	}
}
