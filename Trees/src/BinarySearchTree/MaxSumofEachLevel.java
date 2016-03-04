package BinarySearchTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaxSumofEachLevel {

	public int maxSumLevel(Node root){
		if(root==null){
			return 0;
		}
		Queue<Node> que = new LinkedList<Node>();
		HashMap <Integer, Integer> SumLevel = new HashMap<Integer, Integer>();
		Map.Entry<Integer, Integer> entry = null;
		int level=0;
		que.add(root);
		while(!que.isEmpty()){
			level++;
			int size = que.size();
			Node temp = que.poll();
			while(size>0){
				int sum = 0;
				if(temp.left!=null){
					que.add(temp.left);
					sum = sum + temp.left.value;
				}
				if(temp.right!=null){
					que.add(temp.right);
					sum = sum + temp.right.value;
				}
				SumLevel.put(level, sum);
			}
			
			entry = null;
			for(Map.Entry<Integer, Integer> e : SumLevel.entrySet()){
				if(e.getValue() > entry.getValue()){
					entry = e;
				}
			}			
		}
		return entry.getKey();
	}
}
