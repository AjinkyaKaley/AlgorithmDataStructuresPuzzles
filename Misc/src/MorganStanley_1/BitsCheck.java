package MorganStanley_1;

public class BitsCheck {

	public static void main(String[] args) {
		int num = 30;
		
		x : for(int i= 1; i<= (new Double(Math.pow(2,num)).intValue()); i++){

			boolean isPrev = false;
			int n = i;
			while(n>0){
				if(n%2 == 1 && isPrev){
					
					continue x;
				}
				isPrev = (n%2==1);
				n = n/2;
			}
			System.out.println(i);
		}
	}
}
