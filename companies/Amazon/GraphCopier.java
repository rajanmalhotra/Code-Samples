package companies.Amazon;

import java.util.HashMap;
import java.util.Vector;
import java.util.LinkedList;
import com.rajan.crackingcoding.graphs.*;
import com.rajan.crackingcoding.graphs.Graph;
import com.rajan.crackingcoding.graphs.GraphNode;

public class GraphCopier {
	
	public static GraphNode copyGraph(Graph g){
		GraphNode current = g.vertices.get(0);
		LinkedList<GraphNode> list = new LinkedList<GraphNode>();
		HashMap<GraphNode, GraphNode> map = new HashMap<GraphNode, GraphNode>();
		GraphNode newCurrent = new GraphNode(current.id);
		GraphNode newNode = null;
		list.add(current);
		map.put(current, newCurrent);

		while(!list.isEmpty()){
			current = list.get(0);
			newCurrent = map.get(current);
			for(GraphNode node : current.adjacent){
				if(!map.containsKey(node)){
					newNode = new GraphNode(node.id);
					map.put(node, newNode);
					list.add(node);
				}else{
					newNode = map.get(node);
				}
				newCurrent.adjacent.add(newNode);
				newNode.adjacent.add(newNode);
			}
			list.remove(current);
		}
		return map.get(g.vertices.get(0));
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
		DepthFirstSearch.depthFirstSearch(nodes[0]);
		GraphNode newNode = copyGraph(graph);
		DepthFirstSearch.depthFirstSearch(newNode);		
	}
}

