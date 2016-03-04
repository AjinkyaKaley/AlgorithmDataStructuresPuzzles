package BinarySearchTree;

import java.util.ArrayList;
import java.util.HashMap;

public class InOrderPreOrder {



	public Node buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder) {

		HashMap<Integer, Integer> lookup = new HashMap<Integer, Integer>();

		for(int i=0 ;i<inorder.size();i++){
			lookup.put(inorder.get(i),i);
		}

		return TreeBuilder(preorder,inorder,lookup,0,inorder.size()-1, null);
	}

	int pre_idx=0;
	public Node TreeBuilder(ArrayList<Integer> preorder, ArrayList<Integer> inorder, 
			HashMap<Integer, Integer> lookup, int low, int high, Node root ){

		if(low > high){
			return null;
		}

		root = new Node(preorder.get(pre_idx));
		int idx = lookup.get(preorder.get(pre_idx));
		pre_idx++;
		root.left = TreeBuilder(preorder,inorder,lookup,low,idx-1, root.left);
		root.right = TreeBuilder(preorder,inorder,lookup,idx+1,high, root.right);
		return root;

	}
	
	public static void main(String[] args) {
		InOrderPreOrder ip = new InOrderPreOrder();
		
		int [] ino = {1,2,3};
		int [] pre = {2,1,3};
	
		ArrayList<Integer> inorder = new ArrayList<Integer>();
		inorder.add(1);
		inorder.add(2);
		inorder.add(3);
		
		ArrayList<Integer> postorder = new ArrayList<Integer>();
		postorder.add(2);
		postorder.add(1);
		postorder.add(3);
		
		
		ip.buildTree(postorder, inorder);
	}


}
