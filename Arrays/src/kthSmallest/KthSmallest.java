package kthSmallest;

import java.awt.List;
import java.util.ArrayList;

public class KthSmallest {

	
	public int kthsmallest(final ArrayList<Integer> a, int k) {
		 
	       if(a.size() == 0){
	           return -1;
	       }
	       
	       ArrayList<Integer> b = new ArrayList<Integer>(a);
	       return process(b,0,a.size()-1,k);
	}
	
	public int process(ArrayList<Integer> a, int low, int high, int k){
	    
	    int pos = partition(a,low,high);
	    
	    if(pos == k-1){
	        return a.get(pos);
	    }
	    
	    if(pos < k-1){
	        // right
	        return process(a, pos + 1, high, k);
	    }
	    
	    return process(a, low, pos - 1, k);
	
	}
	
	public int partition(ArrayList<Integer> a, int low, int high){
	    
	    int pivot = a.get(low);
	    int idx = low;
	    low++;
	    
	    while(low < high){
	        while(a.get(low) > pivot && low < a.size()){
	            low++;
	        }
	    
	        while(a.get(high) < pivot && high >= 0 ){
	            high--;
	        }
	    
	        if(low < high){
	            int temp = a.get(low);
	            a.set(low, a.get(high));
	            a.set(high, temp);
	        }
	    }
	    
	    int temp = a.get(high);
	    a.set(high, pivot);
	    a.set(idx, temp);
	    return high;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> i = new ArrayList<Integer>();
	
		i.add(2);
		i.add(1);
		i.add(4);
		i.add(3);
		i.add(2);
		
		KthSmallest ks = new KthSmallest();
		System.out.println(ks.kthsmallest(i, 3));
	}

}
