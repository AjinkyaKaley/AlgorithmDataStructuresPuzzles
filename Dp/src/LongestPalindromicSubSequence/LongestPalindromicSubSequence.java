package LongestPalindromicSubSequence;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingDeque;

public class LongestPalindromicSubSequence {

	public void LPS(int [][] sol, String str){
		
		for(int i=0;i<str.length();i++){
			sol[i][i] = 1;
		}
		
		
		for(int size = 2;size<=str.length();size++){
			
			for(int j=0;j<str.length()-size+1;j++){
				int k = j + size-1;
				
				if(size==2 && str.charAt(j)==str.charAt(k)){ 
					sol[j][k] = 2;
				}
				else if(str.charAt(j)==str.charAt(k)){
					sol[j][k] = 2+sol[j+1][k-1];
				}
				else{
					sol[j][k] = Math.max(sol[j+1][k], sol[j][k-1]);
				}
			}
			
		}
		backtrack(sol, str);
		
	}
	
	
	public void backtrack(int[][] sol, String str){
		
		int i=0;
		int j= sol[0].length-1;
		
		while(i!=j){
			
			if(sol[i][j-1] == sol[i+1][j]){
				System.out.println(str.charAt(i) + " " +str.charAt(i));
				i++;
				j--;
			}
			else{
				if(sol[i][j-1] > sol[i+1][j]){
					j = j-1;
				}
				else{
					i = i+1;
				}
			}
			
		}
	}
	public static void main(String[] args) {
		String str = "agbdba";
		LongestPalindromicSubSequence lp= new LongestPalindromicSubSequence();
		int [][] sol = new int[str.length()][str.length()];
		lp.LPS(sol, str);
	}
}
