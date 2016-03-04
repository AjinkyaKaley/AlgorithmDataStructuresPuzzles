package BinarySearchTree;

import java.util.Stack;

public class PostOrderIterative {

	public void PostOrderiterative(Node root){
		if(root == null){
			return ;
		}
		
		Stack<Node> stack_1 = new Stack<Node>();
		Stack<Node> stack_2 = new Stack<Node>();
		
		stack_1.push(root);
		
		while(!stack_1.isEmpty()){
			root = stack_1.pop();
			stack_2.push(root);
			if(root.left!=null){
				stack_1.push(root.left);
			}
			if(root.right!=null){
				stack_1.push(root.right);
			}
		}
		
		while(!stack_2.isEmpty()){
			System.out.print(stack_2.pop().value + "\t");
		}
	}
}
