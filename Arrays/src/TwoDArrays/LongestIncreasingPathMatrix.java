package TwoDArrays;

public class LongestIncreasingPathMatrix {

	int max=0;
	
	public int LIP(int [][] matrix, int x, int y, int path_count){
		
		
		// Moving right
		if(check(matrix,matrix[0].length-1,matrix.length-1,x,y+1)){
			if(matrix[x][y+1] > matrix[x][y]){
				int temp = matrix[x][y];
				matrix[x][y] = Integer.MIN_VALUE;
				int len = LIP(matrix,x,y+1,path_count+1);
				max = Math.max(max,len );
				matrix[x][y] = temp;
			}
		}
		
		if(check(matrix,matrix[0].length-1,matrix.length-1,x,y-1)){

			if(matrix[x][y-1] > matrix[x][y]){
				int temp = matrix[x][y];
				matrix[x][y] = Integer.MIN_VALUE;
				int len= LIP(matrix,x,y-1,path_count+1);
				max = Math.max(max,len );
				matrix[x][y] = temp;
			}
		}
	
		if(check(matrix,matrix[0].length-1,matrix.length-1,x+1,y)){
			if(matrix[x+1][y] > matrix[x][y]){				
				int temp = matrix[x][y];
				matrix[x][y] = Integer.MIN_VALUE;
				int len = LIP(matrix,x+1,y,path_count+1);
				max = Math.max(max,len );
				matrix[x][y] = temp;
			}
		}
		
		if(check(matrix,matrix[0].length-1,matrix.length-1,x-1,y)){

			if(matrix[x-1][y] > matrix[x][y]){				
				int temp = matrix[x][y];
				matrix[x][y] = Integer.MIN_VALUE;
				int len = LIP(matrix,x-1,y,path_count+1);
				max = Math.max(max,len );
				matrix[x][y] = temp;
			}
		}
		
		return path_count;
	}
	
	private boolean check(int[][] matrix, int i, int j, int x, int y) {
		// TODO Auto-generated method stub
		if(x<=j && y<=i && x >=0 && y>=0 && matrix[x][y] != Integer.MIN_VALUE){
			return true;
		}
		return false;
	}
	
	public int process(int matrix[][]){
		int maxLen=Integer.MIN_VALUE;
		int len=0;
		for(int i=0;i<matrix.length;i++){
			for(int j=0; j<matrix[0].length;j++){
				len = LIP(matrix,i,j,1);
				maxLen = Math.max(max, maxLen);
				max=0;				
			}
		}
		return maxLen;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestIncreasingPathMatrix lip = new LongestIncreasingPathMatrix();
		
		
		  
		 
		int [][]  matrix =  {{0,1,2,3,4,5,6,7,8,9},
				  {19,18,17,16,15,14,13,12,11,10},
					 {20,21,22,23,24,25,26,27,28,29},
					  {39,38,37,36,35,34,33,32,31,30},
					  {40,41,42,43,44,45,46,47,48,49},
					  {59,58,57,56,55,54,53,52,51,50},
					  {60,61,62,63,64,65,66,67,68,69},
					  {79,78,77,76,75,74,73,72,71,70},
					  {80,81,82,83,84,85,86,87,88,89},
					  {99,98,97,96,95,94,93,92,91,90},
					  {100,101,102,103,104,105,106,107,108,109},
					  {119,118,117,116,115,114,113,112,111,110},
					  {120,121,122,123,124,125,126,127,128,129},
					  {139,138,137,136,135,134,133,132,131,130},
					  {0,0,0,0,0,0,0,0,0,0}}
					 ;
		System.out.println(lip.process(matrix)); ;
	}

}
