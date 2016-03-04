package Intersection;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoList {



	// DO NOT MODIFY THE LISTS
	public ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {
	    
	    int first_ptr = 0;
	    int second_ptr = 0;
	    List<Integer> bigger;
	    List<Integer> smaller;
	    
	    if(a.size() < b.size()){
	        bigger = new ArrayList<Integer>(b);
	        
	        smaller = a;    
	    }
	    else{
	        bigger = a;
	        smaller = b;
	    }
	    
	    ArrayList<Integer> solution = new ArrayList<Integer>();
	    
	    while(first_ptr< bigger.size() && second_ptr < smaller.size()){
	        int one = bigger.get(first_ptr);
	        int second = smaller.get(second_ptr);
	        
	        System.out.println(one + " " + second);
	        if(bigger.get(first_ptr) == smaller.get(second_ptr)){
	            solution.add(bigger.get(first_ptr));
	            first_ptr++;
	            second_ptr++;
	        }
	        else{
	            if(smaller.get(second_ptr) <= bigger.get(first_ptr)){
	                second_ptr++;
	            }
	            else{
	                first_ptr++;
	            }
	        }
	    }
	    return solution;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list1 = new ArrayList<Integer>();

		list1.add(1000);
		/*list1.add(2);
		list1.add(3);
		list1.add(3);
		list1.add(4);
*/

		ArrayList<Integer> list2 = new ArrayList<Integer>();

		list2.add(1000);
	/*	list2.add(3);
		list2.add(3);
		list2.add(4);
		list2.add(4);
		list2.add(4);
		list2.add(10);*/
		
		IntersectionOfTwoList itwo = new IntersectionOfTwoList();
		ArrayList<Integer> sol = itwo.intersect(list1, list2);
		
		for(int a : sol){
			System.out.print(a + " ");
		}
		System.out.println();

	}

}
