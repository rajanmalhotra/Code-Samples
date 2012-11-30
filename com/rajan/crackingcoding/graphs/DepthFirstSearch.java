package com.rajan.crackingcoding.graphs;

import java.util.Vector;

public class DepthFirstSearch {
	public static void depthFirstSearch(GraphNode root){
		if(root==null){
			return;
		}
		root.visited = true;
		System.out.println(root.id);
		for(GraphNode node : root.adjacent){
			if(node.visited==false){
				depthFirstSearch(node);
			}
		}
	}
	
	public static void main(String[] args){
		GraphNode[] nodes = new GraphNode[5];
		/* Nodes'id start from 0 */
		for(int i=0; i < nodes.length; i++){
			nodes[i] = new GraphNode(i);
		}
		Vector<GraphNode> list0 = new Vector<GraphNode>();
		list0.add(nodes[1]);
		list0.add(nodes[2]);
		Vector<GraphNode> list1 = new Vector<GraphNode>();
		list1.add(nodes[0]);
		list1.add(nodes[3]);
		list1.add(nodes[4]);
		Vector<GraphNode> list2 = new Vector<GraphNode>();
		list2.add(nodes[0]);
		list2.add(nodes[4]);
		Vector<GraphNode> list3 = new Vector<GraphNode>();
		list3.add(nodes[1]);
		list3.add(nodes[4]);
		Vector<GraphNode> list4 = new Vector<GraphNode>();
		list4.add(nodes[1]);
		list4.add(nodes[2]);
		list4.add(nodes[3]);
		Graph graph = new Graph(5);
		graph.insertNode(nodes[0], list0);
		graph.insertNode(nodes[1], list1);
		graph.insertNode(nodes[2], list2);
		graph.insertNode(nodes[3], list3);
		graph.insertNode(nodes[4], list4);
		depthFirstSearch(nodes[4]);
	}
}
