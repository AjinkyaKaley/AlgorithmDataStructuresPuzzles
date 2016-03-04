package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelPrintBst {

	public void levelprint(Node root){
		Queue<Node> queue = new LinkedList<Node>();
		System.out.println();
		System.out.println("-----------------");
		queue.add(root);
		
		while(!queue.isEmpty()){
			
			Node temp_node = queue.poll();
			if(temp_node!=null){
				System.out.print(temp_node.value + "\t");
				
				if(temp_node.left!=null){					
					queue.add(temp_node.left);
				}
				if(temp_node.right!=null){
					queue.add(temp_node.right);
				}
			}
			System.out.println();
		}
	}
}
