package ReverseLinkedList;

public class CycleLinkedList {

	public Node cycle(Node n)
	{
		
		if(n == null){
			return null;
		}
		
		Node fast = n;
		Node slow = n;
				
		while(true){
			
			fast = fast.next;
			if(fast == null){
				return null;
			}
			slow = slow.next;
			fast = fast.next;
			if(fast == null){
				return null;
			}
			if(fast == slow){
				break;
			}
		}
		slow = n;
		while(slow!=fast){
			slow=slow.next;
			fast=fast.next;
		} 
		return fast;
	}
	
	public static void main(String[] args) {
		Node n1 = new Node(100);
		Node n2 = new Node(5);
		Node n3 = new Node(3);
		Node n4 = new Node(9);
		Node n5 = new Node(15);		
		Node n6 = new Node(17);
		Node n7 = new Node(8);
		Node n8 = new Node(20);
		Node n9 = new Node(31);
		Node n10 = new Node(45);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = n10;
		n10.next = n3;
		
		CycleLinkedList c = new CycleLinkedList();
		
		System.out.println(c.cycle(n1).value);
	}
}
