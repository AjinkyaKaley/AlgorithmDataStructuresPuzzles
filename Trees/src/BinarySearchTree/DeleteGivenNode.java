package BinarySearchTree;

public class DeleteGivenNode {

	public void deleteGive(Node root, int value){
		BinarySearchTree bst = new BinarySearchTree();
		Node delete_node = bst.Search(root, 25);
		
		DeepestNodeInBinaryTree deep = new DeepestNodeInBinaryTree();
		Node lastNode = deep.deepNodeUsingQueue(delete_node);
		
		delete_node.value = lastNode.value;
		
		Node temp = lastNode.parent;
		if(temp.left == lastNode){
			temp.left=null;
		}
		else if(temp.right==lastNode){
			temp.right=null;
		}
	}
}
