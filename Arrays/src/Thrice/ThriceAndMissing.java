package Thrice;

public class ThriceAndMissing {

	
	public void thrice(int[] arr){
		
		int [] ones = new int[32];
		int [] twos = new int[32];
		int idx1=0, idx2=0;
		int counter=0;
		for(int i=0;i<arr.length;i++){
			
			int num = arr[i];
			counter=0;
			
			while(num!=0){
				int x = (num & 1);
				if(x==1){
					ones[counter]++;  
				}
				else{
					twos[counter]++;
					//twos[counter] = 1;
				}
				num = num>>1;
				counter++;
			}
		}
		
		
		for(int a : ones){
			System.out.print(" "+a);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {3,17,3,6,3,6,6};
		ThriceAndMissing t = new ThriceAndMissing();
		t.thrice(arr);
		
	} 

}
