package ReverseArray;

public class ReverseArray {

	public static int [] reverse(int [] array){
		if(array.length == 0){
			return null;
		}
		
		int low = 0;
		int high = array.length-1;
		
		while(low < high){
			array[low] = array[low] ^ array[high];
			array[high] = array[low] ^ array[high];
			array[low] = array[low]^array[high];			
			low++;
			high--;
		}
		
		for(int i : array){
			System.out.print(i + " ");
		}
		return array;
	}
	
	
	public static void rotation_algo(int [] array, int d){
		int n = array.length;
		int [] A = new int[d];
		int [] B = new int[n-d];
		
		for(int i=0;i<array.length ;i++){
			A[i] = array[i];
		}
		
		for(int j=d; j<n;j++){
			B[j] = array[j];
		}
	
		A = reverse(A);
		B = reverse(B);
		int [] C = new int [n];
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] array = {1,23,4,24,5,6,78,9};
		reverse(array);
	}

}
