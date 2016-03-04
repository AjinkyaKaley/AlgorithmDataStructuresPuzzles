package BinarySearchTree;
import java.util.*;
public class CountLeafNodes {
	
	public int countLeaf(Node root){
		
		if(root==null){
			return 0;
		}
		
		Queue<Node> que = new LinkedList<Node>();
		que.add(root);
		int count = 0;
		while(!que.isEmpty()){
			Node temp = que.poll();
			if(temp.left == null && temp.right == null){
				++count;
			}
			if(temp.left!=null){
				que.add(temp.left);
			}
			if(temp.right!=null){
				que.add(temp.right);
			}
		}
		return count;
	}
	
	public int countUsingRecursion(Node root){
		if(root.left == null && root.right==null){
			return 1;
		}
		return countUsingRecursion(root.left) + countLeaf(root.right);
	}

}
