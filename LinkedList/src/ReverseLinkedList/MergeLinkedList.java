package ReverseLinkedList;

public class MergeLinkedList {

	public Node merge(Node n1, Node n2){
		Node p1 = n1;
		Node p2 = n2;
		Node ans = new Node(-99);
		Node temp = ans;
		while(p1 != null &&  p2!= null){
			
			if(p1.value < p2.value){
				ans.next = p1;
				p1 = p1.next;
				ans = ans.next;
				
			}
			else{
				ans.next = p2;
				p2 = p2.next;
				ans = ans.next;
			}
		}
		
		while(p1 != null){
			ans.next = p1;
			ans = ans.next;
			p1 = p1.next;
		}
		
		while(p2 != null){
			ans.next = p2;
			ans = ans.next;
			p2=p2.next;
		}
		return temp;
	}
	
	public static void main(String[] args) {
		Node n10 = new Node(3);
		Node n11 = new Node(5);
		Node n12 = new Node(9);
		Node n13 = new Node(13);
		Node n14 = new Node(14);
		Node n15 = new Node(25);
		Node n16 = new Node(30);
		
		n10.next = n11;
		n11.next = n12;
		n12.next = n13;
		n13.next = n14;
		n14.next = n15;
		n15.next = n16;
		
		Node n20 = new Node(0);
		Node n21 = new Node(1);
		Node n22 = new Node(2);
		Node n23 = new Node(11);
		Node n24 = new Node(15);
		
		n20.next = n21;
		n21.next= n22;
		n22.next =n23;
		n23.next = n24;
		
		/*Node n25 = new Node(2);
		Node n26 = new Node(2);*/
		
		MergeLinkedList  m = new MergeLinkedList();
		Node ans = m.merge(n10, n20);
		
		while(ans!=null){
			System.out.println(ans.value);
			ans = ans.next;
		}
		
	}
}
