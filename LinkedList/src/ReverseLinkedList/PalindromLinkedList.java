package ReverseLinkedList;

public class PalindromLinkedList {

	public boolean isPalindrom( Node n, Node[] head){
		
		
		if(n.next==null){
			if(n.value == head[0].value){
				head[0] = head[0].next;
				return true;
			}
			else{
				return false;
			}
		}
		boolean f = isPalindrom(n.next, head);
		System.out.println(n.value+" "+head[0].value);
		if(f && (n.value == head[0].value)){
			head[0] = head[0].next;
			return true;
		}
		else{
			return false;
		}
	}
	
	public static void main(String[] args) {
		
		Integer i = null;
				
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(99);		
		Node n6 = new Node(4);
		Node n7 = new Node(3);
		Node n8 = new Node(2);
		Node n9 = new Node(1);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = null;
		
		PalindromLinkedList p = new PalindromLinkedList();
		Node[] na = new Node[1];
		na[0]=n1;
		System.out.println(p.isPalindrom(n1, na));
	}
}


