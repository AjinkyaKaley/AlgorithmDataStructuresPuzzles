
public class BubbleSort {
	
	
	public void bubblesort(int [] arr){
		
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length-1;j++){
				
				if(arr[j] > arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		BubbleSort bs = new BubbleSort();
		int [] arr ={5,1,12,-5,16};
		bs.bubblesort(arr);
		
		for(int a : arr){
			System.out.print(a + " ");
		}
		
	}

}
