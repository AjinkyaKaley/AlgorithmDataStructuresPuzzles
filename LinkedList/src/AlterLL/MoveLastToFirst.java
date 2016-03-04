package AlterLL;
import ReverseLinkedList.Node;

public class MoveLastToFirst {

	public static Node lastTofirst(Node root, Node head){
		
		if(root==null)
			return null;
		
		if(root.next.next==null){
			Node temp = root.next;
			root.next = null;
			return temp;
		}
		Node head_t = lastTofirst(root.next, head);
		head_t.next = head;
		return head_t;
		
	}
	
	
}
