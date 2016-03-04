package BinarySearchTree;

public class CountSubTrees {
	int count=0;
	public void subtrees(Node root){
		
		if(root!=null){
			subtrees(root.left);
			subtrees(root.right);
			
			if(root.left!=null && root.right!=null)
			{
				count++;
			}
		}
		
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		/*root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(11);
		root.right.left.left = new Node(12);
		root.right.left.right =new Node(13);
		root.right.right.left = new Node(14);*/
		//root.right.right.right = new Node(15);
		
		CountSubTrees c = new CountSubTrees();
		c.subtrees(root);
		System.out.println(c.count);
		
	}
}
