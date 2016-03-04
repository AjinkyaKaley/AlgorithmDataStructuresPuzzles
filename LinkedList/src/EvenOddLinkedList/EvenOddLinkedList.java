package EvenOddLinkedList;

import ReverseLinkedList.Node;

public class EvenOddLinkedList {

	public Node doIt(Node head){
		
		if(head== null){
			return null;
		}
		//1-2-3-4-5-6
		Node OddHead = head;
		Node EvenHead = head.next;
		Node OddTrailer = head;
		Node EvenTrailer = head.next;
		
		while(EvenTrailer != null && EvenTrailer.next!=null){
			
			if(OddTrailer.next.next!=null){				
				OddTrailer.next = OddTrailer.next.next;
				OddTrailer = OddTrailer.next;
			}
			
			EvenTrailer.next = EvenTrailer.next.next;
			EvenTrailer = EvenTrailer.next;
			
		}
	
		OddTrailer.next = EvenHead;
		return OddHead;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		EvenOddLinkedList eo = new EvenOddLinkedList();
		Node res = eo.doIt(n1);
		
		while(res!=null){
			System.out.println(res.value);
			res = res.next;
		}
		
	}
}
