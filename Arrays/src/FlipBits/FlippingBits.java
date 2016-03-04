package FlipBits;

import java.util.ArrayList;

public class FlippingBits {

	public void flip(String str){

		ArrayList<Pair> sol = new ArrayList<Pair>();

		int n = str.length();
		int x = (int)Math.pow(2,n)-1;
		if( x == Integer.parseInt(str,2)){
			System.out.println("DOne");
		}

		int val = Integer.parseInt(str,2);
		int max = Integer.MIN_VALUE;
		int pre_count=0;
		
		for(int i=0;i<n;i++){

			for(int j=i;j<n;j++){

				int left = i;
				int right = j;

				int temp=val;
				for(;left <= right;left++){

					int bitPos = n-left-1;

					temp = temp ^ (1 << bitPos);
				}
				int m = temp;
				System.out.println(Integer.toBinaryString(temp));
				int count=0;
				while(m!=0){
					m = m & (m-1);
					count++;
				}

				if(count >= pre_count){
					sol.add(new Pair(i,j));
					pre_count = count;
				}
				 
				temp = 0;

			}
		}

		for(Pair num : sol){
			System.out.println(num.i + " " + num.j);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FlippingBits fb = new FlippingBits();
		fb.flip("010");

	}


	class Pair{
		int i;
		int j;

		public Pair(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
}
