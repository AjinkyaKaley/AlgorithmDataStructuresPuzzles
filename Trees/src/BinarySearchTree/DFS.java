package BinarySearchTree;

import java.util.Stack;

public class DFS {

	Node root;
	
	public DFS(int value){
		this.root = new Node(value);
	}
	
	public void insert(Node root){
	
		Stack<Node> s = new Stack<Node>();
		s.push(root);
		
		while(!s.isEmpty()){
			s.push(root.left);
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
