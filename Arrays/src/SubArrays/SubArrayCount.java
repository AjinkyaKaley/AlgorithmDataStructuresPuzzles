package SubArrays;

public class SubArrayCount {

	public static void main(String[] args) {
		
		
		int [] num = {1,2,3,4};
		int cnt=0;
		for(int i=0;i<num.length; i++){
			
			for(int j=i+1;j<num.length;j++){
				
				if(num[j] > num[j-1]){
					cnt++;
				}
				else{
					break;
				}
			}
		}
		
		System.out.println(cnt);
	}
	
}
