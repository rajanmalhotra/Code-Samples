package com.rajan.crackingcoding.graphs;

import java.util.Vector;

public class Graph {
	public Vector<GraphNode> vertices = new Vector<GraphNode>();
	int countNodes;
	
	public Graph(int count){
		countNodes = count;
	}
	
	public void insertNode(GraphNode root, Vector<GraphNode> neighbours){
		vertices.add(root);
		for(GraphNode node:neighbours){
			if(!vertices.contains(node)){
				vertices.add(node);
			}
			node.adjacent.add(root);
			root.adjacent.add(node);
		}
	}
}
