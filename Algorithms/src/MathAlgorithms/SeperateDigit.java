package MathAlgorithms;

public class SeperateDigit {

	public static void main(String[] args) {
		int n = 1234;
		
		while(n!=0){
			int d = n%10;
			n = n/10;
			System.out.println(d);
		}
	}
}
