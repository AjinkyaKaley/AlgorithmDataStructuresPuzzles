package DeletNode;

import ReverseLinkedList.Node;

public class CompareTwoList {

	int CompareLists(Node headA, Node headB) {
		// This is a "method-only" submission. 
		// You only need to complete this method 
		int ret_value = 0;

		while(true){


			headA = headA.next;

			headB = headB.next;

			if(headA == null && headB == null){	
				return 1;
			}
			
			if(headA == null && headB!=null){
				return 0;
			}
			
			if(headA !=null && headB== null){
				return 0;
			}
			
			if(headA.value == headB.value){
				ret_value = 1;
				continue;
			}
			else{
				ret_value = 0; 
				break;
			}
		}
		return ret_value;
	}
	public static void main(String[] args) {
		CompareTwoList t = new CompareTwoList();
		Node n0 = new Node();
		Node n1 = new Node(3);
		Node n2 = new Node(5);
		Node n3 = new Node(14);
		Node n4 = new Node(76);

		n0.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;

		Node n01 = new Node();
		Node n11 = new Node(3);
		Node n12 = new Node(5);
		Node n13 = new Node(14);
		Node n14 = new Node(76);
/*
		n01.next = n11;
		n11.next = n12;
		n12.next = n13;
		n13.next = n14;
				*/
		int i =t.CompareLists(n0, n01);

		System.out.println(i);

	}
}
