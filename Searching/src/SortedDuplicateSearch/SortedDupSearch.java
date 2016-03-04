package SortedDuplicateSearch;

public class SortedDupSearch {

	public int search(int [] A, int val){

		int high=A.length-1, low=0, mid =0;
		while(high >= low){
			mid = low + (high-low)/2;
			if(A[mid] == val ){				
				if(mid > 0 && A[mid-1] == val){
					high = mid -1;
				}
				else{
					return mid;
				}				
			}

			else{
				if(A[mid]>val){
					high = mid -1;
				}
				else{
					low = mid+1;
				}
			}
		}
		return mid;
	}


	public int recursive_sol(int [] A, int val, int low, int high){

		
		int mid = low + (high - low)/2;

		if(A[mid]==val){
			
			if(low == mid){
				return low;
			}
			else{
				recursive_sol(A,val,low,mid);
			}
			
		}
		
		/*if(A[mid] == val){
			if(mid > 0 && A[mid-1] == val){
				return recursive_sol(A, val, low, mid-1);
			}
			else{
				return mid;
			}
		}
		else{
		 */	
		if(A[mid] >= val){
			return recursive_sol(A, val, low, mid-1);
		}
		else{
			return recursive_sol(A, val, mid+1, high);
		}

	}
	public static void main(String[] args) {
		int [] A = {1,2,2,4,5,5};
		SortedDupSearch s = new SortedDupSearch();
		int i = s.search(A, 1);
		//System.out.println(i);
		int j = s.recursive_sol(A, 5, 0, A.length);
		System.out.println(j);
	}
}
