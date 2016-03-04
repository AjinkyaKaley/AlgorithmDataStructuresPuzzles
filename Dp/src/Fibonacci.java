
public class Fibonacci {

	
	public int recursive(int n){
		
		if(n==0){
			return 0;
		}
		
		if(n==1){
			return 1;
		}
		
		int temp = recursive(n-1)+recursive(n-2);
		System.out.println(temp);
		return temp;
	}
	public static void main(String[] args) {
		int n=10;
		int [] sol = new int[n+1];
		
		Fibonacci fb = new Fibonacci();
		fb.recursive(10);
		
	}
}

