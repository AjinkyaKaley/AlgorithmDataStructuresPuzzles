package BinarySearch;

public class BinarySearch {

	public int binarysearch(int [] input, int high, int low, int target){
		int mid = (low + high)/2;
		
		if(input[mid]==target){
			return mid;
		}
		else if (input[mid]<target)
			return binarysearch(input, mid, low, target);	
		else 
			return binarysearch(input, high, mid+1, target);
		
	}
	public static void main(String[] args) {
		BinarySearch b = new BinarySearch();
		int [] input = {10,11,12,14,15,156,325};
		int pos = b.binarysearch(input, input.length, 0, 14);
		System.out.println(pos);
	}
}
