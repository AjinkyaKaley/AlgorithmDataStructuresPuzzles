package MergeSort;

class MergeSort{
	
	
	public int [] sort(int [] A){
		
		if(A.length<=1){
			return A;
		}
		else{
			int midpoint = (A.length/2);
			int [] left = null;
			int [] right = null;
			if(A.length%2==0){
				left = new int[midpoint];
				right = new int[midpoint];
			}
			else{
				left = new int[midpoint];
				right = new int[midpoint+1];
			}
			int [] result = new int[A.length];
			
			for(int i=0; i<midpoint;i++){
				left[i] = A[i];
			}
			
			int x=0;
			
			for(int j =midpoint; j< A.length; j++){				
					right[x]=A[j];
					x++;				
			}
			
			left = sort(left);
			right = sort(right);
			
			return merge(left, right);			
			
		}
		
	}
	
	
	private int[] merge(int[] left, int[] right) {
		
		int result[] = new int[left.length + right.length];
		int length_of_result = result.length;
		int index_right=0;
		int index_left = 0;
		int indexResult=0;
		
		while(index_right< right.length || index_left< left.length){
			
			if(index_right< right.length && index_left< left.length){
				
				if(left[index_left]<=right[index_right]){
					result[indexResult] = left[index_left];
					index_left++;
					indexResult++;
				}
				else{
					result[indexResult] = right[index_right];
					index_right++;
					indexResult++;
				}
				
			}
			else if(index_left<left.length){
				result[indexResult]=left[index_left];
				indexResult++;
				index_left++;
			}
			else if(index_right<right.length){
				result[indexResult] = right[index_right];
				indexResult++;
				index_right++;
			}
		}
		
		
		return result;
	}
	public static void main(String[] args) {
	
		MergeSort m = new MergeSort();
		int [] input = {5,2,4,6,1,3,2,6};
		input = m.sort(input);
		for(int i:input){
			System.out.println(i);
		}
	}
}