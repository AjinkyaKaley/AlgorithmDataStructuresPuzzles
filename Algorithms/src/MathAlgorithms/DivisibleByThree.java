package MathAlgorithms;

public class DivisibleByThree {

	public static void main(String[] args) {
		int n = 23;
		int even_count = 0;
		int odd_count = 0;
		
		while(n!=0){
			int temp = n & 1;
			if(temp == 1){
				odd_count++;
			}
			n = n>>1;
			temp = n & 1;
			if(temp==1){
				even_count++;
			}
			n = n>>1;
		}
		
		System.out.println(odd_count - even_count);
	}
}
