package com.rajan.crackingcoding.ch2;

public class TwoLinkedListsWeaver {
	
	public static void appendLinkedLists(Node<Object> first, Node<Object> second){
		Node<Object> ptr1 = first;
		if(first==null){
			return;
		}
		
		while(ptr1.next!=null){
			ptr1 = ptr1.next;
		}
		ptr1.next = second;
	}

	public static void weaveLinkedLists(Node<Object> first){
		if(first==null){
			return;		
		}

		Node<Object> ptr1 = first;
		Node<Object> ptr2 = first.next;
		while(ptr2!=null && ptr2.next!=null){
			ptr1 = ptr1.next;
			ptr2 = ptr2.next.next;
		}
		Node<Object> prev = ptr1;
		ptr1 = ptr1.next;
		prev.next = null;
		ptr2 = first;
		
		Node<Object> next = first;
		while(ptr1!=null){
			next =  ptr2.next;
			ptr2.next = ptr1;
			ptr1 = ptr1.next;			
			ptr2.next.next = next;
			ptr2 = ptr2.next.next;
		}
	}
	
	public static void main(String[] args){
		LinkedList<Object> first = new LinkedList<Object>();
		for(int i=1; i <= 10; i++){
			first.append(i);		
		}
			
		LinkedList<Object> second = new LinkedList<Object>();
		for(char i=65; i <= 74; i++){
			second.append(i);		
		}
		System.out.println("First List : ");
		first.print();
		System.out.println("Second List : ");
		second.print();		
		appendLinkedLists(first.head, second.head);
		System.out.println("Appending the lists : ");
		first.print();
		weaveLinkedLists(first.head);
		System.out.println("Weaving the lists : ");
		first.print();
	}
}
