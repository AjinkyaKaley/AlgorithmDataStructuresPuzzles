package BinarySearchTree;

import java.util.ArrayList;

public class CartesianTreeReconstruct {

	

    public Node buildTree(ArrayList<Integer> a) {
        
        if(a.size()==1){
            return new Node(a.get(0));
        }
        
        return TreeBuilder(a,0,a.size()-1, null);
        
        
    }
    
    
    public Node TreeBuilder(ArrayList<Integer> a, int low, int high, Node root){
        
        if(low > high){
            return null;
        }
        System.out.println("Hello world");
        
        int max_idx = max(a, low, high);
        
        root = new Node(a.get(max_idx));
        if(low == high){
            return root;
        }
        
        root.left = TreeBuilder(a,low, max_idx-1, root.left);
        root.right = TreeBuilder(a, max_idx+1, high, root.right);
        return root;
    }
    
    
    
    public int max(ArrayList<Integer> a, int low, int high){
        
        int max = Integer.MIN_VALUE;
        int idx=-1;
        for(int i=low;i<=high;i++){
            
            if(max < a.get(i)){
                idx = i;
                max = a.get(i);
            } 
        }
        return idx;
    }
    
    
    public static void main(String[] args) {
		CartesianTreeReconstruct cr = new CartesianTreeReconstruct();
		ArrayList<Integer> x = new ArrayList<Integer>();
		x.add(1);
		x.add(2);
		x.add(3);
		cr.buildTree(x);
	}

}
