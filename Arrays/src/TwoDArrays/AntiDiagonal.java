package TwoDArrays;

import java.util.ArrayList;

public class AntiDiagonal {
	
	public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	    if(a==null || a.size()==0){
	        return res;
	    }
	    doThisJob(a,0,0,res);
	    
	    return res;
	}
	
	
	public void doThisJob(ArrayList<ArrayList<Integer>> a, int start, int end, ArrayList<ArrayList<Integer>> res){
	    
	    while(end < a.size()){
	       fill(a,res,start,end);
	       end++;
	    }
	    
	    start=1;
	    end -= 1;
	    while(start<a.size()){
	        fill(a,res,start,end);
	        start++;
	    }
	}
	
	public void fill(ArrayList<ArrayList<Integer>> a, ArrayList<ArrayList<Integer>> res,int start, int end){
	        ArrayList<Integer> t = new ArrayList<Integer>();
	        int down = end;
	        while(start<=down){
	            t.add(a.get(start).get(end));
	            start++;
	            end--;
	        }
	        res.add(t);
	    }
	
	
	public static void main(String[] args) {
		AntiDiagonal ad = new AntiDiagonal();
		ArrayList<ArrayList<Integer>> a=new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> r1 = new ArrayList<Integer>();
		r1.add(1);
		r1.add(2);
		r1.add(3);
		ArrayList<Integer> r2 = new ArrayList<Integer>();
		r2.add(4);
		r2.add(5);
		r2.add(6);
		ArrayList<Integer> r3 = new ArrayList<Integer>();
		r3.add(7);
		r3.add(8);
		r3.add(9);
		a.add(r1);
		a.add(r2);
		a.add(r3);
		ArrayList<ArrayList<Integer>> res = ad.diagonal(a);
		
		/*for(int i=0;i<a.size();i++){
			for(int j=0;j<res.size();j++){
				System.out.print(res.get(i).get(j) + " ");
			}
			System.out.println();
		}*/
		
		
		ArrayList<Integer> t = new ArrayList<Integer>(r1);
	}
	
}

