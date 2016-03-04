package AdditionUsingIncDec;

public class AdditionIncDec {

	public static void main(String[] args) {
		int a = -5;
		int b = 3;
		
		while(a>0){
			--a;
			b++;
		}
		while(a<0){
			a++;
			b--;
		}
		
		System.out.println(b);
	}
}
