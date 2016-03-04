package MissingElement;

public class MissingElement {

	public int missingElement(int[] array, int start, int end){
		int sum=0;
		int expected_sum = 0;
		for(int i : array){
			sum+=i;
		}
		
		for(int i = start ; i <= end; i++){
			expected_sum+=i;
		}
		
		return expected_sum-sum;
	}
	
	public static void main(String[] args) {
		MissingElement m = new MissingElement();
		int [] array = {1,2,3,4,5,6,8};
		System.out.println(m.missingElement(array, 0, 8));
		
	}
}
