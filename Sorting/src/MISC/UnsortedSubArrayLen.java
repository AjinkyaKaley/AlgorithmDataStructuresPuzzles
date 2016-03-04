package MISC;

public class UnsortedSubArrayLen {

	// 10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60
	public static int unsortedsubArray(int [] arr){
		
		int start = 0;
		
		while(start < arr.length && arr[start] < arr[start+1]){
			start++;
		}
		
		int end = arr.length-1;
		
		while(end >= 0 && arr[end] > arr[end-1]){
			end--;
		}
		
		int [] minMax = findMinMax(arr,start,end);
		int indx1=start;
		for(int i=0;i<start;i++){
			if(arr[i] > minMax[0]){
				indx1 = i;
				break;
			}
		}
		int indx2=end;
		for(int j=end+1;j<arr.length;j++){
			if(arr[j] < minMax[1]){
				indx2 = j;
				break;
			}
		}
		System.out.println(indx1 + " " + indx2);
		return indx2 - indx1;
	}
	//10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60
	public static int[] findMinMax(int[] arr, int start, int end){

		int [] vals = {arr[start],arr.length};
		start++;
		for(;start<=end;start++){
			if(vals[0] > arr[start]){
				vals[0] = arr[start];
			}
			else if(vals[1] < arr[start]){
				vals[1] = arr[start];
			}
		}
		
		return vals;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] nums = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
		System.out.println(unsortedsubArray(nums));
		
	}

}
