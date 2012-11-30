package com.rajan.crackingcoding.ch2;

public class SampleNode{
	int data;
	SampleNode next = null;

	public SampleNode(int d){
		data = d;
	}

	// append a node to the linked list
	public void appendToTail(int d){
		SampleNode end = new SampleNode(d);
		SampleNode n = this;
		while(n.next!=null){
			n = n.next;		
		}
		n.next = end;
	}

	// delete a node from the linked list
	public SampleNode deleteNode(SampleNode head, int d){
		SampleNode n = head;
		if(n.data == d){
			return head.next;		
		}
		while(n.next!=null){
			if(n.next.data == d){
				n.next = n.next.next;
				return head;
			}
			n = n.next;		
		}
		return n;
	}
}
