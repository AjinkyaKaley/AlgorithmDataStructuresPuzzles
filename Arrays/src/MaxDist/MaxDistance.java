package MaxDist;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;

public class MaxDistance {

	
	public int maxdist(int [] nums){
		
		int n = nums.length;
		int [] Lmin = new int[n];
		int [] Rmax = new int[n];
		
		Lmin[0] = nums[0];
		
		for(int i=1;i<nums.length;i++){
			Lmin[i] = Math.min(Lmin[i-1], nums[i]);
		}
		
		
		Rmax[n-1] = nums[n-1];
		
		for(int j= n-2; j>=0 ;j--){
			Rmax[j] = Math.max(Rmax[j+1], nums[j]);
		}
		
		
		int i =0, j=0, maxDiff = -1;
		
		while(i < n && j<n){
			if(Lmin[i] < Rmax[j]){
				maxDiff = Math.max(maxDiff, j-1);
				j = j+1;
			}
			else{
				i = i+1;
			}
		}
		return maxDiff;
	}
	
	public int alternate(ArrayList<Integer> nums){

	    
	    ArrayList<Pair> lookup = new ArrayList<Pair>();
	    for(int i=0;i<nums.size();i++){
            lookup.add(new Pair(nums.get(i),i));	        
	    }
	    
	    Collections.sort(nums);
	    
	    int maxDiff = -1;
	    
	    for(int i=0;i<nums.size();i++){
	        
	    	int val= nums.get(i);
	    	
	    	int i_idx = getIndx(lookup, val,i);
	    	
	    	for(int j=i+1;j<nums.size();j++){

	        	if(nums.get(i) <= nums.get(j)){
	                int temp = getIndx(lookup, nums.get(j),j); 
	                maxDiff = Math.max(maxDiff, temp - i_idx);
	            }
	        }
	    }
	    return maxDiff;
	
		
	}
	
	
	public int getIndx(ArrayList<Pair> lookup,int val, int k){
		int i_idx=-1;
		for(;k<lookup.size();k++){
    		Pair p = lookup.get(k);
    		if(p.val == val){
    			i_idx = p.index;
    			break;
    		}
    	}
		return i_idx;
	}
	
	class Pair{
	    int val;
	    int index;
	    
	    public Pair(int val, int index){
	        this.val = val;
	        this.index = index;
	    }
	}
	
	public static void main(String[] args) {
		int [] nums1 = {3,2,1};
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i=0;i<nums1.length;i++){
			nums.add(nums1[i]);
		}
		MaxDistance md = new MaxDistance();
		System.out.println(md.alternate(nums));
	}
}
