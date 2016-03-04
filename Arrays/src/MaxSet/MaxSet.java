package MaxSet;

import java.util.ArrayList;

public class MaxSet {


	public ArrayList<Integer> maxset(ArrayList<Integer> a) {
	    int max_start=0;
	    int max_end=0;
	    int sum=0;
	    int maxSum=Integer.MIN_VALUE;
	    int start=0;
	    int end =0;
	    for(int i=0;i<a.size();i++){
	       
	       if(a.get(i)>=0){
	           sum = sum+a.get(i);

	           if(sum>maxSum){
	               max_end = i;
	               maxSum = sum;
	           }
	           else if(sum==maxSum){
	               if((end - start) > (i - max_start)){
	                   start = max_start;
	                   max_end = i;
	               }
	               else if((end - start) == (i - max_start)){
	                   if(start < max_start){
	                       max_end = end;
	                   }
	                   else{
	                       start = max_start;
	                       max_end = i;
	                   }
	               }
	           }
	       } 
	       else{
	           start = max_start;
	           end = max_end;
	           max_start = i+1;
	           sum = 0;
	           
	       }
	    }
	    
	    ArrayList<Integer> res = new ArrayList<Integer>();
	    
	    for(int i=start;i<=max_end;i++){
	        res.add(a.get(i));
	    }
	    return res;
	}
	
	
	static int[] processArray(int[] array) {


	    for(int i=0;i<array.length;i++){
	        
	        if(i%2 == 0 && i!=0){
	            array[i] = array[i] + array[i-1];
	        }
	        else if(i%3==0 && i>0 && (i + 1)<array.length){
	            array[i] = array[i] ^ array[i+1];
	            array[i+1] = array[i] ^ array[i+1];
	            array[i] = array[i] ^ array[i+1];
	        }
	        else if(i%5==0 && i>0){
	            array[i] = array[i]*2;
	        }
	        else if(i%7==0 || (i%2!=0 && i%3!=0 && i%5!=0)){
	            array[i] = array[i]-1;
	        }
	    }
	    return array;
	}
	
	public static void main(String[] args) {
		MaxSet m=new MaxSet();
		ArrayList<Integer> x = new ArrayList<Integer>();
		x.add(0);
		x.add(0);
		x.add(-1);
		x.add(0);
		/*x.add(6);
		x.add(2);
		x.add(100);*/
		ArrayList<Integer> res;
		res = m.maxset(x);
		
		for(int n:res){
			System.out.print(n + " ");
		}
		
		/*int [] y={0,0,-1,0};
		int [] temp = m.processArray(y);
		for(int i : temp){
			System.out.println(i);
		}
*/	}

}
