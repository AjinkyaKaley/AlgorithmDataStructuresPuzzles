package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

	Node root;

	public BinarySearchTree() {
		
	}
	
	
	
	/**
	 * Swap the two BST
	 */
	/*
	public Node SwapBst(Node node1, Node node2){
		if(node1 == null || node2 == null){
			return null;
		}
		Node parent1 = node1.parent;
		Node parent2 = node2.parent;
		
		
	}
	*/
	/**
	 * Construct a BST from sorted Array
	 */
	public Node BSTfromSortedArray(int [] array, int start, int end){
		
		if(start > end){
			return null;
		}
		int mid = start + (end-start)/2;
		Node root = new Node(array[mid]);
		root.left = BSTfromSortedArray(array, start, mid-1);
		root.right = BSTfromSortedArray(array, mid+1, end);
		return root;
	}
	
	
	
	
	/**
	 * Construct BST from given InOrder and PreOrder
	 */
	Node ROOT;
	static int index_pre = 0;
	public Node BSTfromInOrderPreOrder(int [] preorder, int [] inorder, int start, int end){
		
		if(start > end){
			return null;
		}
		Node root = new Node(preorder[index_pre++]);
		int index = BinarySearch(root.value, 0, inorder.length, inorder);
		root.left = BSTfromInOrderPreOrder(preorder, inorder, start, index-1);
		root.right = BSTfromInOrderPreOrder(preorder, inorder, index+1, end);
		return root;
	}
	
	
	private int[] right_subtree(int i, int [] inorder) {
		// TODO Auto-generated method stub
		
		int index = BinarySearch(i, 0, inorder.length,inorder);
		int [] rightSubTree = new int [inorder.length-index];
		int k =0;
		for(int j = index ; j < inorder.length; j++){
			rightSubTree[k] = inorder[j];
			k++;
		}
		return rightSubTree;
	}
	
	
	public int BinarySearch(int value, int low, int high, int [] array){
		if(low > high){
			return -1;
		}
		
		int mid = (low + high)/2;
		
		if(array[mid]== value)
			return mid;
		else if(array[mid]<value)
			return BinarySearch(value, mid+1, high, array);
		
		else 
			return BinarySearch(value, low, mid-1, array);		
	}


	private int[] left_subtree(int i, int [] inorder) {
		//ArrayList<Integer> leftSubTree = new ArrayList<Integer>();
		int index = BinarySearch(i, 0, inorder.length,inorder);
		int [] leftSubTree = new int[index];
		
		for(int j = 0 ; j < index; j++){
			leftSubTree[j] = inorder[j];	
		}
		return leftSubTree;
	}


	/**
	 * Find the height of left subtree and right subtree
	 * and add 1 because we are not counting from the root
	 * node
	 * 
	 * @param root
	 * @return
	 */
	public int heightOfBinaryST(Node root){
		if(root.left == null && root.right == null){
			return 0;
		}
		int leftSubTreeHeight=0;
		int rightSubTreeHeight=0;
		if(root.left !=null){
			leftSubTreeHeight = heightOfBinaryST(root.left);
		}
		if(root.right!=null){		
			rightSubTreeHeight = heightOfBinaryST(root.right);
		}
		return 1 + Math.max(leftSubTreeHeight, rightSubTreeHeight);
	}
	
	
	
	/**
	 * Height of BST Iterative solution
	 */
	
	public int height_Iterative(Node root){
		int height =0;
		Queue q = new LinkedList<Node>();
		
		q.add(root);
		
		int node_count_in_queue;
		
		while(true){
			node_count_in_queue = q.size();
			
			
			if(node_count_in_queue == 0){
				return height;
			}
			height++;
			
			while(node_count_in_queue>0){
				Node t = (Node)q.poll(); 
				if(t.left!=null){
					q.add(t.left);
				}
				if(t.right!=null){
					q.add(t.right);
				}
				node_count_in_queue--;
			}
		}
	}
	
	
	/**
	 * Predecessor
	 * @param value
	 * @return
	 */
	
	public Node Predecessor(int value){
		Node node = Search(root, value);
		Node parent = node.parent;
		
		if(node.left!=null){
			return Maximum(node.left);
		}
		else{
			while(parent!=null && node == parent.left){
				node = parent;
				parent = parent.parent;
			}
		}
		return parent;
	}
	
	/**
	 * Successors function
	 * @param value
	 * @return
	 */
	public Node Successor(int value){
		Node node = this.Search(this.root, value);
		
		if(node == null){
			return null;
		}
		
		else if(node.right!=null){
			return Minimum(node.right);
		}
		Node parent = node.parent;
		while(parent != null && node == parent.right){
			node = parent;
			parent = parent.parent;
		}
		return parent;
	}
	
	
	/**
	 * Minimum
	 * @param root
	 * @return
	 */
	public Node Minimum(Node root){
		if(root.left == null){
			return root;
		}
		return Minimum(root.left);
	}

	
	/**
	 * Minimum
	 * @param root
	 * @return
	 */
	public Node Maximum(Node root){
		if(root.right == null){
			return root;
		}
		return Maximum(root.right);
	}
	
	
	/**
	 * Searching
	 * @param root
	 * @param value
	 * @return
	 */
	public Node Search(Node root, int value){

		if(root == null){
			return null;
		}
		if(root.value == value){
			return root;
		}
		
		if(value < root.value){
			return Search(root.left, value);
		}
		else
			return Search(root.right, value);			
	}
	
	
	/**
	 * 
	 */
	
	public int Search(Node root, int value, int level){

		if(root == null){
			return 0;
		}
		
		if(root.value == value){
			return level;
		}
		
		if(value < root.value){
			return Search(root.left, value,++level);
		}
		else
			return Search(root.right, value, ++level);			
	}

	/**
	 * Insertion
	 * @param root
	 * @param value
	 */
	public void insert(Node root, int value){

		if(root == null){
			Node n = new Node(value);
			this.root = n;
			//n.parent = this.root;			
			return;
		}

		if(root.left == null && value < root.value){
			Node n = new Node(value);
			root.left = n;
			n.parent = root;
			return;
		}
		else if(root.right == null && value > root.value){
			Node n = new Node(value);
			root.right = n;
			n.parent = root;
			return;
		}		

		if(value < root.value){
			insert(root.left, value);
		}
		else if(value > root.value){
			insert(root.right, value);
		}
	}

	
	/**
	 * PostOrder
	 * @param root
	 */
	public void PostOrder(Node root){
		if(root == null){
			return;
		}
		PostOrder(root.left);
		PostOrder(root.right);
		System.out.println(root.value);
	}
	
	
	/**
	 * PreOrder
	 * @param root
	 */

	public void PreOrder(Node root){
		if(root==null){
			return;
		}
		System.out.println(root.value);
		PreOrder(root.left);
		PreOrder(root.right);
	}

	/**
	 * InOrder
	 * @param root
	 */
	public void inOrder(Node root){
		if(root == null){
			return;
		}
		inOrder(root.left);
		System.out.print(root.value + ":" +root.id + " /");
		inOrder(root.right);
	}
	
	
	/**
	 * Converting BinarySearchTree to Doubly LinkedList
	 * 
	 * @param root
	 * @return
	 */
	
	public Node BstToDll(Node root){
		
		if(root == null){
			return null;
		}
		
		Node pred = Predecessor(root.value);
		
		if(pred!=null){
			this.root.parent = pred;
			pred.left = this.root;
			pred.right = this.root.right;
			this.root.right = null;
			this.root = pred;
			if(pred.parent.left == pred){
				pred.parent.left = null;
			}
			else if(pred.parent.right == pred){
				pred.parent.right = null;
			}
			pred.parent = null;
		}
		
		Node succ = Successor(pred.right.value);
		
		if(succ!=null){
			pred.parent = succ;
			succ.right = pred.right;
			pred.right = null;
			succ.left = pred;
			
			if(succ.parent.right == succ){
				succ.parent.right = null;
			}
			else if(succ.parent.left == succ){
				succ.parent.left = null;
			}		
		}
		return Minimum(succ);
	}
	
	
	public Node delete(int value){
		Node delete_node = Search(this.root,value);
		
		if(delete_node == null){
			return null;
		}
		
		if(delete_node.right == null  && delete_node.left == null){
			Node d = delete_node.parent;
			
			if(d.left == delete_node){
				d.left = null;
			}
			
			else if(d.right == delete_node){
				d.right = delete_node;
			}
			return this.root;
		}
		else if(delete_node.right != null && delete_node.left == null){
			Node parent = delete_node.parent;
			Node temp;
			if(parent.right == delete_node){
				temp = delete_node.right;
				parent.right = temp;
				temp.parent = parent;
			}
			else if(parent.left == delete_node){
				temp = delete_node.right;
				parent.right = temp;
				temp.parent = parent;
			}
		}
		
		else if (delete_node.left !=null && delete_node.right != null){
			Node succ = Successor(delete_node.value);
			Node succ_parent = succ.parent;
			
			if(succ.right!=null){
				succ_parent.left = succ.right;
				succ.right.parent = succ_parent;
				delete_node.value = succ.value;
			}
			else{
				delete_node.value = succ.value;
				succ_parent.left = null;
			}
			
		}
		
		return this.root;
	}
	
	Node lca;
	public Node LCA( Node node1, Node root, Node node2){
		if(node1==null || node2==null){
			return null;
		}
		if(node1.value < root.value && node2.value > root.value){
			lca = root;
		}
		if(node1.value < root.value && node2.value < root.value){
			LCA(node1, root.left, node2);
		}
		else if(node2.value > root.value && node2.value > root.value){
			LCA(node1, root.right, node2);
		}
		return lca;
	}
	
	
	public Node delete(Node root, int data){
		if(root == null){
			return null;
		}
		else if(data < root.value){
			root.left = delete(root.left, data);
		}
		else if(data > root.value){
			root.right = delete(root.right, data);
		}
		
		else{
			if(root.left==null && root.right==null){
				root = null;
			}
			else if(root.left!=null && root.right==null){
				Node temp = root;
				root = root.left;
				temp = null;
			}
			else if(root.right!=null && root.left==null){
				Node temp = root;
				root = root.right;
				temp = null;
			}
			else {
				Node temp =Successor(root.value);
				root.value = temp.value;
				root.right = delete(root.right, temp.value);
			}
		}
		return root;
	}

	public static void main(String[] args) {
		BinarySearchTree b = new BinarySearchTree();

		/*b.insert(b.root, 10);
		b.insert(b.root, 5);
		b.insert(b.root, 20);
		b.insert(b.root, 3);
		b.insert(b.root, 4);
		b.insert(b.root, 100);
		b.insert(b.root, 50);
		b.insert(b.root, 21);
		b.insert(b.root, 33);*/
		/*b.insert(b.root, 45);
		b.insert(b.root, 1);
		b.insert(b.root, 15);
		b.insert(b.root, 28);
		b.insert(b.root, 36);
		b.insert(b.root, 400);*/
		
		
		b.insert(b.root, 5);
		b.insert(b.root, 10);
		b.insert(b.root, 3);
		b.insert(b.root, 4);
		b.insert(b.root, 1);
		b.insert(b.root, 11);
	/*	b.insert(b.root, 30);
		b.insert(b.root, 23);*/
		/*b.insert(b.root, 24);
		b.insert(b.root, 21);*/
		//System.out.println(b.Search(b.root, 5, 0));
		//NodeDeletion del = new NodeDeletion();
		Node r = b.delete(b.root, 10);
		System.out.println("----------");
		b.inOrder(r);

		
/*		b.inOrder(b.root);
		try{

			Node t =b.Search(b.root, 5);
			System.out.println();
			System.out.println(t.value + ":" + t.id);
		}
		catch (Exception e){
			System.out.println("Not Found");
		}*/
		
		/*Node succ = b.Successor(36);
		System.out.println(succ.value + ":"+ succ.id);
		*/
//		Node x = b.BstToDll(b.root);
//		Node u = b.Search(b.root, 10);
//		Node p = b.Maximum(u);
		
//	/	Node del = b.delete(20);
		//System.out.println(de.value);
		/*Node n1 = b.Search(b.root, 5);
		Node n2 = b.Search(b.root, 10);
		Node n = b.LCA(n1, b.root, n2);*/
		//System.out.println(n.value);
		
		//System.out.println(b.height_Iterative(b.root));
		/*Node n1 = new Node(20);
		Node n2 = new Node(10);
		Node n3 = new Node(30);
		n1.left=n2;
		n1.right=n3;*/
		//System.out.println(b.heightOfBinaryST((b.root)));
		
		/*int [] inorder = {9,12,14,17,19,23,50,57,67,72,76};
		int [] preorder ={50,17,12,9,14,23,19,72,54,67,76};
		
		Node temp = b.BSTfromInOrderPreOrder(preorder, inorder, 0, inorder.length);*/
		
		/*InOrderIteration inorder = new InOrderIteration();
		inorder.InOrder(b.root);
		
		LevelPrintBst level_print = new LevelPrintBst();
		level_print.levelprint(b.root);
		
		PreOrderIterative preOrder = new PreOrderIterative();
		preOrder.preOrderItervative(b.root);
		System.out.println();
		PostOrderIterative postOrder = new PostOrderIterative();
		postOrder.PostOrderiterative(b.root);
		System.out.println();
		System.out.println("Printing levelwise in reverse order");
		PrintLevelReverseOrder printLevelRev = new PrintLevelReverseOrder();
		printLevelRev.printBSFreverse(b.root);
		
		System.out.println();
		System.out.println("Deepest Node and its level in the Binary Tree");
		DeepestNodeInBinaryTree deep = new DeepestNodeInBinaryTree();
		deep.deepNode(b.root);
		System.out.println("Deepest Node and its level in the Binary Tree using queues");
		deep.deepNodeUsingQueue(b.root);
		
		System.out.println("Count of leaf nodes");
		CountLeafNodes count = new CountLeafNodes();
		System.out.println(count.countUsingRecursion(b.root));
		
		System.out.println("Count of leaf nodes");
		System.out.println(count.countLeaf(b.root));
		
		System.out.println("Summation of all the nodes");
		SumOfAllElements sum = new SumOfAllElements();
		System.out.println(sum.Summation(b.root));
*/	}
}

class Node{
	int value;
	Node parent;
	Node left;
	Node right;
	int id;

	public Node(int value){
		this.value = value;
		this.id = this.hashCode()/10000000;
	}
	
	public Node(){}
}