package ReverseLinkedList;

import AlterLL.MoveLastToFirst;
import DeleteLinkedList.DeleteLinkedList;

public class LinkedList_1{
	Node head = null;
	Node pointer = null;
	public static void main(String[] args) {

		Node n1 = new Node(5);
		Node n2 = new Node(55);
		Node n3 = new Node(155);
		Node n4 = new Node(45);
		Node n5 = new Node(12);
		n1.next = n2;
		n2.next = n3;
		n3.next = null;
		/*n3.next = n4;
		n4.next = n5;
		n5.next = null;*/


		/*ReverseLinkedList r = new ReverseLinkedList();
		Node n = r.reverse(n1);*/
		
		/*Node he = DeleteLinkedList.deleteLL(n1);
		if(he==null){
			System.out.println("Done");
		}*/
		
		Node n = MoveLastToFirst.lastTofirst(n1, n1);
		while(n!=null){
			System.out.print(n.value + " ");
			n=n.next;
		}
		
	}
}
/*class Node{
	int val;
	Node next;
	
	Node(int i){
		val = i;
	}
}*/

