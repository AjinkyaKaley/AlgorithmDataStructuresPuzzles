package Dup;

import ReverseLinkedList.Node;

public class Duplicates {
	
public Node deleteDuplicates(Node a) {
	
	    
	    Node first = a;
	    Node second = a.next;
	    Node thrid = null;
	    Node prev;
	    
	    while(second!=null){
	        
	        if(first.value == second.value){
	            prev = first;
	            while(first.value == second.value){
	                first.next = second.next;
	                second = second.next;
	            }
	            if(thrid == null){
	                thrid = first.next;
	                a = thrid;
	            }
	            else{
	                thrid.next = first.next;
	                //thrid = thrid.next;
	                //first = first.next;
	            }
	            first = first.next;
	            second = second.next;
	        }
	        else{	        	
	        	thrid = first;
	        	first = second;
	        	second = second.next;
	        	
	        }
	        
	    }
	    return a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node head = new Node(1);
		Node n1 = new Node(1);
		Node n2 = new Node(1);
		Node n3 = new Node(2);
		Node n4 = new Node(3);
		Node n5 = new Node(4);
		Node n6 = new Node(4);
		//Node n7 = new Node(5);
		
		head.next = n1;
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=n6;
		n6.next=null;
		//n7.next=null;
		
		Duplicates d = new Duplicates();
		Node a = d.deleteDuplicates(head);
		
		while(a!=null){
			System.out.print(a.value);
			a = a.next;
		}
	}

}
