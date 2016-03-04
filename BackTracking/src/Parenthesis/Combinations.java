package Parenthesis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        Arrays.sort(candidates);
        List<List<Integer>> sol = new ArrayList<List<Integer>>();
        backtrac(sol,candidates, target, new ArrayList<Integer>(),0);
    
        return sol;
    }
    
    
    public void backtrac(List<List<Integer>> sol, int[] candidates, int target, ArrayList<Integer> list, int start){
        
        if(target > 0){
            
            for(int i= start;i<candidates.length;i++){
                list.add(candidates[i]);
                backtrac(sol,candidates,target-candidates[i],list,start);
                list.remove(list.size()-1);
                
            }
            
        }
        
        if(target == 0){
            sol.add(new ArrayList<Integer>(list));
        }
    }
    
    public static void main(String[] args) {
		int [] num = {1};
		Combinations c=new Combinations();
		c.combinationSum(num, 1);
	}
}
