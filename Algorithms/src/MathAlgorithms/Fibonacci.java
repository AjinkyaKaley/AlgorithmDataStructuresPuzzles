package MathAlgorithms;

public class Fibonacci {

	public static int fibonacci(int i){
		if(i <= 1){
			return i;
		}
		int x =fibonacci(i-1)+ fibonacci(i-2);
		System.out.println(x);
		return x;
	}
	
	public static void main(String[] args) {
//		int i = fibonacci(5);
		System.out.println(fibonacci(5));
	}
}
