package MathAlgorithms;

public class Pow {

	public int pow(int x, int y){
		
		if(y==0){
			return 1; 
		}
		
		int temp = pow(x,y/2);
		
		if(y%2==0){
			return temp * temp;
		}
		return x * temp * temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Pow p = new Pow();
		int x=2;
		p.pow(x, 3);
		System.out.println(x);
	}

}
