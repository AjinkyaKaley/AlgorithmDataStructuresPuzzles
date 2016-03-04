package InsertionSOrt;

public class InsertionSort {

	private static void insertionSort(int[] nums, int length) {

		for(int i=1;i<length;i++){
			int value = nums[i];
			int hole = i;
			
			while(hole>0 && nums[hole-1] > value){
				nums[hole] = nums[hole-1];
				hole = hole-1;
			}
			nums[hole] = value;
			for(int j : nums){
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] nums = {1,4,3,5,6,2};

		insertionSort(nums,nums.length);
		
		
		/*for(int a: nums){
			System.out.print(a + " ");
		}*/
	}


}
