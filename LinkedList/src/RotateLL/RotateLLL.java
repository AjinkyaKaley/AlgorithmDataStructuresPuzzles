package RotateLL;

import ReverseLinkedList.Node;


public class RotateLLL {


	public Node rotateRight(Node head, int k) {

		int length = 0;
		Node trailer = head;

		while(trailer!=null){
			trailer = trailer.next;
			length++;        
		}

		if(head == null || k==0 || k>= length){
			return head;
		}

		k = k % length;

		trailer=head;
		int count=0;
		while( count < length-k-1){
			trailer = trailer.next;
			count++;
		}
		Node secondPart = trailer.next;
		trailer.next = null;
		Node temp = reverse(head);
		Node temp_head = temp;
		Node temp2 = reverse(secondPart);

		while(temp.next!=null){
			temp= temp.next;
		}
		temp.next = temp2;
		
		head = reverse(temp_head);
		return head;
	}


	public Node reverse(Node head){

		if(head == null){
			return head;
		}

		if(head.next==null){
			return head;
		}

		Node temp = reverse(head.next);
		head.next.next = head;
		head.next=null;
		return temp;
	}


	public static void main(String[] args) {

		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = null;
		
		
		RotateLLL ro = new RotateLLL();
		head = ro.rotateRight(head, 2);
		
		while(head!=null){
			System.out.print(head.value);
			head = head.next;
		}
	}
}


