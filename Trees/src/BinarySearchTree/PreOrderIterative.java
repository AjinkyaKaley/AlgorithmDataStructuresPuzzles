package BinarySearchTree;

import java.util.Stack;

public class PreOrderIterative {

	Node root;
	public PreOrderIterative(int value){
		this.root = new Node(value);
	}
	public void preOrderItervative(Node root){
		if(root == null){
			return;
		}
		System.out.println();
		Stack<Node>  stack = new Stack<Node>();
		stack.push(root);
		
		while(!stack.isEmpty()){
			Node temp = stack.pop();
			System.out.print(temp.value + "\t");
			
			if(temp.right!=null){
				stack.push(temp.right);
			}	
			else{
				System.out.println("-1");
			}
			if(temp.left!=null){
				stack.push(temp.left);
			}
			else{
				System.out.println("-1");
			}
		}
	}
	
	public Node insert(Node root, int value){
		if(root == null){
			return new Node(value);
		}
		if(value < root.value){
			root.left = insert(root.left,value);
		}
		else{
			root.right = insert(root.right, value);
		}
		return root;
	}
	
	public static void main(String[] args) {
		PreOrderIterative p = new PreOrderIterative(20);
		p.insert(p.root, 8);
		p.insert(p.root, 4);
		p.insert(p.root, 12);
		p.insert(p.root, 10);
		p.insert(p.root, 14);
		
		p.preOrderItervative(p.root);
	}
}
