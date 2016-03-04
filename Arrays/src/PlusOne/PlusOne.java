package PlusOne;

import java.util.*;
public class PlusOne {

	
	public ArrayList<Integer> plusOne(ArrayList<Integer> number){
		
		if(number == null || number.size()==0){
			return new ArrayList<Integer>();
		}
		int sum=1;
		int carry=0;
		Stack<Integer> st = new Stack<Integer>();
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		ArrayList<Integer> processed = process(number);
		for(int i=processed.size()-1;i>=0;i--){
			sum = sum + processed.get(i)+carry;
			carry = (sum/10 == 1) ? 1:0;
			st.push(sum%10);
			sum = 0;	
		}
		
		if(carry == 1){
			st.push(carry);
		}
		
		while(!st.isEmpty()){
			
			res.add(st.pop());
		}
		return res;
	}
	private ArrayList<Integer> process(ArrayList<Integer> number) {
		// TODO Auto-generated method stub
		int count=0;
		ArrayList<Integer> new_list = new ArrayList<Integer>();
		for(int x:number){
			if(x==0){
				count++;
			}
			else{
				break;
			}
		}
		
		if(count==0){
			return number;
		}
		
		for(;count<number.size();count++){
			new_list.add(number.get(count));
		}
		return new_list;
	}
	public static void main(String[] args) {
		PlusOne po = new PlusOne();
		ArrayList<Integer> x = new ArrayList<Integer>();
		x.add(0);
		x.add(0);
		x.add(0);
		x.add(1);
		x.add(2);
		x.add(3);
		ArrayList<Integer> y = po.plusOne(x);
		
		for(int m : y){
			System.out.print(m + " ");
		}
	}

}
