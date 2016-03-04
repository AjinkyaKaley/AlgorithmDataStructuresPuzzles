package DeleteLinkedList;

import ReverseLinkedList.Node;

public class DeleteLinkedList {

	public static Node deleteLL(Node root){
		if(root == null){
			return null;
		}
		if(root.next == null){
			return null;
		}
		Node head = deleteLL(root.next);
		return head;
	}
}
