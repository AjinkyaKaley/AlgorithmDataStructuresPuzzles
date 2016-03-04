package MathAlgorithms;

public class PowWithOutMultipOperator {

	public static int multiply(int a, int b){
		
		if(b==1){
			return a;
		}
		
		int x = multiply(a, b-1);
		int ans = 0;
		for(int i =0;i<a;i++){
			ans = ans+x;
		}
		
		return ans;
		
	}
	public static void main(String[] args) {
		System.out.println(multiply(5, 6));
	}
}
