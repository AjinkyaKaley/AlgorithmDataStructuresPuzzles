package PrettyPrint;

import java.util.ArrayList;

public class PreetyPrint2D {

	
	public void prettyprint(int a){
		
		
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		int offset =0;
		int row;
		int coloums = a+a-1;
		int pointer = a-2;
		
		
		for(row =0;row<a;row++){
			offset = row-1;
			ArrayList<Integer> t = new ArrayList<Integer>();
			
			for(int col =0;col<coloums;col++){
				
				if(row == 0 || col == 0 || col == coloums-1){
					t.add(a);
					continue;
				}
				else if(col <= offset || col >= coloums-1-offset){
					t.add(res.get(row-1).get(col));
					continue;
				}
				else{
					t.add(a-row);
				}
			}
			res.add(t);
		}
		
		for(;row<coloums;row++){
			
			ArrayList<Integer> t = new ArrayList<Integer>(res.get(pointer));
			res.add(t);
			pointer--;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PreetyPrint2D p = new PreetyPrint2D();
		p.prettyprint(5);
	}

}
