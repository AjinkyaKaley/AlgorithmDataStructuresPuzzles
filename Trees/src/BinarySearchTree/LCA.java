package BinarySearchTree;

public class LCA {

	public Node lca(Node root, Node n1, Node n2){
		
		
		if(root == null || root.value == n1.value || root.value == n2.value){
			return root;
		}
		
		Node left = lca(root.left, n1, n2);
		Node right = lca(root.right, n1, n2);
		
		if(left!=null && right != null){
			return root;
		}
		
		return left!=null ? left : right;
		
	}
	public static void main(String[] args) {
		LCA Lca = new LCA();
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		Node c = Lca.lca(root, new Node(4), new Node(7));
		System.out.println(c.value);
	}
}
