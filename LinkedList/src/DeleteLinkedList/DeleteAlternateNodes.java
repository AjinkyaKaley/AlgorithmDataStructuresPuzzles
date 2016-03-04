package DeleteLinkedList;

import ReverseLinkedList.Node;

public class DeleteAlternateNodes {

	Node head = null, pointer = null;
	
	
	public DeleteAlternateNodes(){
		
	}
	
	public void insert(int value){
	
		if(head == null){
			head = new Node(value);
			pointer = head;
		}
		else{
			pointer.next = new Node(value);
			pointer = pointer.next;
		}	
	}
	
	
	public Node PairWiseSwap(Node head){
		if(head==null){
			return null;
		}
		
		Node firstP = head, secondP=head.next;
		
		while(secondP!=null){
			firstP.value = firstP.value ^ secondP.value;
			secondP.value = firstP.value ^ secondP.value;
			firstP.value = firstP.value ^ secondP.value;
			
			if(secondP.next!=null){				
				firstP = secondP.next;
				secondP = secondP.next.next;
			}
			else{
				break;
			}
		}
		return head;
	}
	
	
	public Node alternate_delete(Node head){
		if(head == null){
			return null;
		}
		Node first= head, second = head.next;
		int count = 0;
		
		while(true){
			first.next = second.next;
			second.next = null;
			if(first.next!=null){
				first = first.next;
			}
			if(first.next!=null){
				second = first.next;
			}
			else{
				break;
			}
		}
		return head;
	}
	
	public void print(Node head){
		
		while(head!=null){
			System.out.println(head.value);
			head = head.next;
		}
	}
	public static void main(String[] args) {
		DeleteAlternateNodes del = new DeleteAlternateNodes();
		del.insert(1);
		del.insert(21);
		del.insert(32);
		del.insert(100);
		//del.insert(45);
		//del.print(del.head);
		
		//Node swapped = del.PairWiseSwap(del.head);
		//del.print(del.head);
		System.out.println("----Alt Delete----");
		Node del_alt = del.alternate_delete(del.head);
		del.print(del_alt);
	}
}
