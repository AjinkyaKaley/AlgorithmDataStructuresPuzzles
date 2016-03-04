package TextJustification;

public class TextJustification {

	
	public void fillMatrix(int [][] cost, String[] words, int width){
	
		cost = new int[words.length-1][words.length-1];
		
		for(int i=0;i<words.length;i++){
			cost[i][i] = width - words[0].length();
			for(int j=i+1;j<words.length;j++){
				cost[i][j] = cost[i][j-1] + words[j].length()-1;
			}
		}
		
		
		for(int i=0;i<words.length;i++){
			for(int j=i;j<words.length;j++){
				if(cost[i][j] < 0){
					cost[i][j] = Integer.MAX_VALUE;
				}
				else{
					cost[i][j] = (int) Math.pow(cost[i][j], 2);
				}
			}
		}
		
		
		int [] minCost = new int[words.length];
		int [] res = new int [words.length];
		
		for(int i=words.length-1;i>=0;i--){
			minCost[i] = cost[i][words.length-1];
			res[i] = words.length;
			
			for(int j=words.length-1;j>i;j--){
				if(cost[i][j] == Integer.MAX_VALUE){
					continue;
				}
				else{
					if(minCost[i] > cost[i][j-1] + minCost[j]){
						minCost[i] = cost[i][j-1] + minCost[j];
						res[i] = j;
					}
				}
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
