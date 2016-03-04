package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PrintLevelReverseOrder {

	public void printBSFreverse(Node root){
		if(root==null){
			return;
		}
		
		Queue<Node>  que = new LinkedList<Node>();
		Stack<Node> stack = new Stack<Node>();
		
		que.add(root);
		while(!que.isEmpty()){
			Node temp = que.poll();
			if(temp.left!=null){
				que.add(temp.left);
			}
			if(temp.right!=null){
				que.add(temp.right);
			}
			stack.push(temp);
		}
		
		while(!stack.isEmpty()){
			System.out.print(stack.pop().value + "\t");
		}
		
	}
}
