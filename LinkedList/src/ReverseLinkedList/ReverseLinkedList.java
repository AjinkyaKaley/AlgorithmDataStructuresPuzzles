package ReverseLinkedList;

public class ReverseLinkedList {

	public Node reverse(Node node){
		if(node == null){
			return null;
		}
		if(node.next==null){
			return node;
		}		
		Node r = reverse(node.next);
		node.next.next= node;
		node.next = null;
		return r;
	}
	
	
	public Node reverseIterative(Node head){
		
		Node current=head;
		Node prev = null;
		Node trailer = head;
		
		while(current !=null){
			Node temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}
		head = prev;
		return head;
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next= new Node(3);
		head.next.next.next=new Node(4);
		head.next.next.next.next=null;
		
		ReverseLinkedList r = new ReverseLinkedList();
		head = r.reverseIterative(head);
		
		while(head!=null){
			System.out.print(head.value+" ");
			head = head.next;
		}
	}
}
