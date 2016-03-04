package BinarySearchTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public class DeepestNodeInBinaryTree {

	/**
	 * 
	 * This uses hashmap
	 * Other solution is to insert everyting in queue by BFS
	 * and then return the last inserted element
	 * @param root
	 */
	public void deepNode(Node root){
		if(root==null){
			return ;
		}
		Queue<Node> queue = new LinkedList<Node>();
		HashMap<Node, Integer> deep = new HashMap<Node,Integer>();
		queue.add(root);
		int level = 0;
		int max_level = 0;
		while(!queue.isEmpty()){		
			
			level++;
			if(level > max_level){
				max_level = level;
			}
			int size = queue.size();
			
			while(size>0){
				Node t = queue.poll();
				if(t.left==null &t.right==null){
					deep.put(t, level);
				}
				if(t.left != null){
					queue.add(t.left);
				}
				if(t.right!=null){
					queue.add(t.right);
				}
				size--;
			}		
		}
		
		Map.Entry<Node, Integer> max = null;
		
		for(Map.Entry<Node, Integer> entry : deep.entrySet()){
			
			if(max == null || entry.getValue().compareTo(max.getValue())>0){
				max = entry;
			}
		}
		
		System.out.println(max.getKey().value);
	}
	
	public Node deepNodeUsingQueue(Node root){
		if(root==null){
			return null;
		}
		Queue<Node> que = new LinkedList<Node>();
		que.add(root);
		Node temp =null;
		while(!que.isEmpty()){
			temp = que.poll();
			if(temp.left!=null){
				que.add(temp.left);
			}
			if(temp.right!=null){
				que.add(temp.right);
			}
		}
		System.out.println(temp.value);
		return temp;
	}
	
	
}
