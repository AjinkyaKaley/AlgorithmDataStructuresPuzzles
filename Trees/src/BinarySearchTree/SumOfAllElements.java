package BinarySearchTree;

public class SumOfAllElements {
	
	public int Summation(Node root){
		if(root.left == null && root.right == null){
			return root.value;
		}
		int left = 0, right = 0;
		if(root.left!=null){
			left = Summation(root.left);
		}
		if(root.right!=null){
			right = Summation(root.right);
		}
		int sum = left + root.value + right;
		System.out.println( sum);
		return  sum;
	}
	
}
