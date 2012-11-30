package com.rajan.crackingcoding.graphs;

import java.util.Vector;

public class GraphNode {
	public int id;
	public boolean visited=false;
	public Vector<GraphNode> adjacent = new Vector<GraphNode>();
		
	public GraphNode(int id){
		this.id = id;
	}
	
	public GraphNode(int id, Vector<GraphNode> adjacent){
		this.id = id;
		this.adjacent = adjacent;
	}	
}
