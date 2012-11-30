package com.rajan.crackingcoding.graphs;

import java.util.LinkedList;
import java.util.Vector;

public class BreadthFirstSearch {
	
	public static void breadthFirstSearch(GraphNode root){
		if(root==null){
			return;
		}
		LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
		root.visited = true;
		queue.offer(root);
		System.out.print(root.id);
		while(!queue.isEmpty()){
			GraphNode current = queue.poll();
			for(GraphNode node : current.adjacent){
				if(node.visited!=true){
					node.visited = true;
					System.out.print(" -> " + node.id);
					queue.offer(node);
				}
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
		breadthFirstSearch(nodes[2]);
	}
}
