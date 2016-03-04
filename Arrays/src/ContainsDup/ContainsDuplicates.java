package ContainsDup;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class ContainsDuplicates {

	

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        
        HashMap<Integer,Queue> lookup = new HashMap<Integer,Queue>();
        
        for(int i=0;i<nums.length;i++){
            
            if(!lookup.containsKey(nums[i])){
                Queue<Integer> temp = new LinkedList<Integer>();
                temp.add(i);
                lookup.put(nums[i],temp); 
            }
            else{
                Queue<Integer> temp = lookup.get(nums[i]);
                temp.add(i);
            }
        }
        
        
        for(int j=0;j<nums.length;j++){
            
            if(lookup.containsKey(nums[j])){
                Queue<Integer> temp = lookup.get(nums[j]);
                int i = temp.remove();
                if(i-j <= k && j!=i){
                    return true;
                }
            }
        }
        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {-1,-1};
		ContainsDuplicates c = new ContainsDuplicates();
		c.containsNearbyDuplicate(nums, 1);
		System.out.println("Hello Owrl");
	}

}
