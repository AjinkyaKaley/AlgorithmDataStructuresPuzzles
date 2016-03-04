package LinkedListAddition;

import ReverseLinkedList.Node;

public class LinkedListAddition {

	int carry = 0;
	int length;
	
	public LinkedListAddition(int l){
		this.length = l;
	}
	
	public LinkedListAddition(){}
	
	public Node addition(Node n1, Node n2){
		
		if(n1 == null && n2 == null){
			return null;
		}
		
		if(n1 != null && n2 == null){
			return n1;
		}
		
		if(n1 == null && n2 != null){
			return n2;
		}
		
		if(n1 == null || n2 == null){
			return null;
		}
		
		Node result = new Node();
		result.next = addition(n1.next, n2.next);
		
		
		int sum = n1.value + n2.value+carry;
		carry = sum/10;
		sum = sum%10;
		
		result.value= sum;
		if(--length == 0){
			Node temp = new Node(carry); 
			temp.next = result;
			return temp;
		}	
		return result;
	}
	
	
	
	public Node addition_unequal_len(Node n1, Node n2){
		
		if(n1 != null && n2 == null){
			return n1;
		}
		
		if(n1 == null && n2 != null){
			return n2;
		}
		
		int l1 = getLength(n1);
		int l2 = getLength(n2);
		
		int diff = Math.abs(l1-l2);
		
		Node large = (l1 > l2) ? n1 : n2;
		Node big = large;
		int count = 0;
		while(count <= diff){
			large = large.next;
		}
		
		Node result = addition(n1, large);
		
		if(carry!=0){			
			addcarryToresult(big, large, carry, result);
		}
		
		
		return null;
		
	}
	
	private void addcarryToresult(Node big, Node large, int carry2, Node result) {
		int sum;
		addcarryToresult(big.next, large, carry2, result);
		sum = big.value + carry2;
		carry2 = carry2 %10;
		sum = sum /10;
		//result.next = 
	}

	public int getLength(Node n){
		int length = 0;
		while(n!=null){
			length++;
			n = n.next;
		}
		return length;
	}
	
	public static void main(String[] args) {
		Node n1 = new Node(2);
		Node n2 = new Node(3);
		Node n3 = new Node(1);
		Node n11 = new Node(8);
		Node n12 = new Node(8);
		Node n13 = new Node(9);
		
		n1.next=n2;
		n2.next=n3;
		n3.next = null;
		
		n11.next=n12;
		n12.next=n13;
		n13.next=null;
		
		
		LinkedListAddition add = new LinkedListAddition();
		add.length = add.getLength(n1);
		Node result = add.addition(n1, n11);
	
		while(result!=null){
			System.out.println(result.value);
			result = result.next;
		}
	}
	
}
