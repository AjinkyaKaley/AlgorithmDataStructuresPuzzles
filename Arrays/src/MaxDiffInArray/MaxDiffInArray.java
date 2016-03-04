package MaxDiffInArray;

public class MaxDiffInArray {

	public static void MaxDiff(int [] array){
		int max_diff = array[1]-array[0];
		int min_element = array[0];
		
		for(int i=0;i<array.length;i++){
			int temp = array[i]-min_element;
			if(max_diff < temp){
				max_diff = temp;
			}
			else if(min_element < array[i]){
				min_element = array[i]; 
			}
		}
		System.out.println("Max Diff : " + max_diff + "Nums : " + (max_diff + min_element) + " " + min_element);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = {2, 3, 10, 6, 4, 8, 1};
		MaxDiff(array);
	}

}
