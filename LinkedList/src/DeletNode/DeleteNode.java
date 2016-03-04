package DeletNode;

import ReverseLinkedList.Node;

public class DeleteNode {


	Node Delete(Node head, int position) {
		// Complete this method
		if(head == null || head.next == null)
		{
			return head;
		}

		if(position == 1)
		{
			Node temp = head.next.next;
			head.next = null;
			return temp;
		}

		Node t = head;
		int count = 0;

		while(t!=null && count < position-1)
		{    
			t = t.next;	
			if(t.next.next == null)
			{
				t.next = null;
				return head;
			}  

			count++;
		}

		t.next.value = t.next.next.value;
		t = t.next;
		t.next = t.next.next;
		return head;

	}

	int count=1;
	public Node process(Node a, Node back, int b){

		if(back == null){
			return back;
		}
		//back = a;
		if(a!=null){	    	
			process(a.next, back.next, b);
			count++;

			if( b-1==count){
				back.next = a.next;
			}
		}
		else if(count == b){

		}
		
		return back;
	}


	public static void main(String[] args) {
		Node n0 = new Node(1);
		Node n1 = new Node(2);
		Node n2 = new Node(3);
		Node n3 = new Node(4);
		Node n4 = new Node(5);
		/*Node n5 = new Node(4);
		Node n6 = new Node(2);
		Node n7 = new Node(67);
		 */
		n0.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = null;
		/*n5.next = n6;
		n6.next = n7;
		 */
		DeleteNode d = new DeleteNode();
		Node head = d.process(n0.next,n0, 5);
		while(head!=null){
			System.out.print(head.value + " ");
			head = head.next;
		}

		while(head!=null){
			System.out.println(head.value);
			head = head.next;
		}
	}
}


/*class Node{
	int data;
	Node next;
	Node(int data)
	{
		this.data = data;
	}
	Node()
	{

	}
}
 */