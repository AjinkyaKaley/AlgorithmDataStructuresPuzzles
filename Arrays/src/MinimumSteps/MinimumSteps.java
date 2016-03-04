package MinimumSteps;

public class MinimumSteps {

	public int minSteps(int [] arr, int low, int high){
		System.out.println(low + " "+ high);
		if(low == high){
			return 0;
		}
		
		if(arr[low] ==0){
			return Integer.MAX_VALUE;
		}
		int min = Integer.MAX_VALUE;
		for(int i=low+1;i<= high && i <= low + arr[low];i++){
			
			int temp = minSteps(arr, i, high);
			System.out.println(temp);
			if(temp!=Integer.MAX_VALUE && temp +1 < min){
				min = temp + 1;
			}
		}
		return min;
	}
	
	
	public int MinSteps(int [] arr){
		
		int [] jumps = new int [arr.length];
		jumps[0] = 0;
		
		for(int i=1;i<arr.length;i++){
			jumps[i] = Integer.MAX_VALUE-1;
		}
		
		for(int i=1;i<arr.length;i++){
			
			for(int j=0;j<i;j++){
				
				if(arr[j] + j >= i){		// Check for the range
					
					if(jumps[i] > jumps[j]+1){
						jumps[i] = jumps[j]+1;
					}
				}
				
			}
		}
		
		return jumps[jumps.length-1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2,3,1,1,4};
				//	 0 1 2 3 4	
		MinimumSteps mp = new MinimumSteps();
		System.out.println(mp.MinSteps(arr));
	}

}
