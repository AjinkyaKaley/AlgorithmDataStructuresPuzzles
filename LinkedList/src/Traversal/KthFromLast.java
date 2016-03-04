package Traversal;

import ReverseLinkedList.Node;

public class KthFromLast {
	
	public static int KtElement(Node node, int k){
		if(node.next==null){
			return 0;
		}
		int i = 1 + KtElement(node.next, k);
		if(i==k){
			System.out.println(node.value);
		}
		return i;
	}

	public static void main(String[] args) {
	
		Node head = new Node(0);
		Node n1 = new Node(2);
		Node n2 = new Node(3);
		Node n3 = new Node(4);
		Node n4 = new Node(5);
		Node n5 = new Node(6);
		
		head.next = n1;
		n1.next = n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=null;
		
		int n = KtElement(head,2);
		System.out.println(n);
		/*while(n!=null){
			System.out.println(n.value);
			n=n.next;
		}*/
	}
	
	
}


/*class Node{
	int value;
	Node next;
	
	Node(int value){
		this.value = value;
	}
}*/