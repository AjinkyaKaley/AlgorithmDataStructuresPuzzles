package RotatedArrayBS;
public class RotatedArraySearch {
	
	public int rotatedSearch(int [] A, int high , int low, int x){
		int pivot = 0;
		int mid = (high+low)/2;
		
		while(low <= high){
			
			if(x == A[mid]){
				return mid;
			}
			  
			if(A[mid] <= A[high]){
				  if(x > A[mid] && x<A[high]){
					  high = mid + 1;
				  }
				  else{
					  low = mid - 1;
				  }
			  }
			else if(A[low] >= A[mid]){
				if(x > A[low] && x < A[mid]){
					high = mid -1;
				}
				else{
					low = mid +1;
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		
	}

}
