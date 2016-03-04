import java.util.Scanner;

public class HackerRank {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String line = sc.nextLine();
		String []  values = line.split(" ");
		
		int N = Integer.parseInt(values[0]);
		int M = Integer.parseInt(values[1]);
		int [] sol = new int[N];
		
		while(M>0){
			line = sc.nextLine();
			String [] temp = line.split(" ");
			
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			int k = Integer.parseInt(temp[2]);
			
			for(int i=a;i<=b;i++){
				sol[i-1] = sol[i-1]+k;
			}	
			M--;
		}
		
		int max=Integer.MIN_VALUE;
		
		for(int a:sol){
			if(a > max){
				max = a;
			}
		}
		System.out.println(max);
	}
}
