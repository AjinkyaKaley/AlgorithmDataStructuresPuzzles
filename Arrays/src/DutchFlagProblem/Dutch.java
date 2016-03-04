package DutchFlagProblem;

public class Dutch {

	public static void swap(int [] arr, int i, int j){
		
		int temp = arr[i];
		arr[i] =arr[j];
		arr[j] =temp;
	}
	
	public static void print(int[] arr){
		for(int a:arr){
			System.out.print(a + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		
		int [] arr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		int i=0;
		int j=0;
		int k=arr.length-1;
		
		
		while(j<k){
			
			if(arr[j] == 0){
				swap(arr,i,j);
				i++;
				j++;
			}
			
			else if(arr[j]==1){
				j++;
			}
			
			else if(arr[j] ==2){
				swap(arr,j,k);
				k--;
			}
			print(arr);
			System.out.println(i + " " + j + " "+k);
		}
		
		for(int num : arr){
			System.out.print(num + " ");
		}
	}
}
