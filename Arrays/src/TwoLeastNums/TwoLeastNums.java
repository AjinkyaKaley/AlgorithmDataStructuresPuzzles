package TwoLeastNums;

public class TwoLeastNums {

	public static void leastTwo(int [] array){
		
		int first = array[0] ;
		int second =array[0];
		int max = Integer.MIN_VALUE;
		
		for(int a: array){
			
			if(first < a){
				second = first;
				first = a;
			}
		}
		System.out.println(first + " " + second);
	}
	public static void main(String[] args) {
		
		int [] a = {37,43,5,64,7,34,66};
		leastTwo(a);
	}
}
