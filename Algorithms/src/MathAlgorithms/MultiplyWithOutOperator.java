package MathAlgorithms;

public class MultiplyWithOutOperator {

	public static void main(String[] args) {
		int a = 5, b=5;
		int count = 0;
		int ans = 0;
		
		while(b!=0){
			int temp = b&1;
			if(temp == 1){
				ans = ans + (a<<count);
			}
			count++;
			b = b>>1;
		}
		System.out.println(ans);
	}
}
