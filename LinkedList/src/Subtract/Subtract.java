package Subtract;

import ReverseLinkedList.Node;

public class Subtract {

	
	public void subract(Node [] head, Node tail, Node[] fast){
		
		if(tail == null){
			return;
		}
		
		subract(head, tail.next, fast);
		
		if(fast[0]!=null && fast[0].next!=null){			
			head[0].value = tail.value - head[0].value;
			
			head[0] = head[0].next;
			fast[0] = fast[0].next;
			
			if(fast[0]!=null){
				fast[0] = fast[0].next;
			}
		}
		
	}
	
	public static void main(String[] args) {
		Node head = new Node(0);
		Node n1 = new Node(2);
		Node n2 = new Node(3);
		Node n3 = new Node(4);
		Node n4 = new Node(5);
		Node n5 = new Node(6);
		Node n6 = new Node(7);
		
		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = null;
		
		Node [] HEAD = {head};
		Node [] fast = {head};
		Subtract s = new Subtract();
		s.subract(HEAD, head, fast);
		
		while(head!=null){
			System.out.print(head.value + " ");
			head = head.next;
		}
	}
}
