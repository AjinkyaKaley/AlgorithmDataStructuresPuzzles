package TwoDArrays;

public class WordSearch {


	public boolean exist(char[][] board, String word) {

		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){

				if(board[i][j] == word.charAt(0)){
					boolean res = dfs(board,i,j,word);

					if(res){
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean dfs(char[][] board, int x,int y, String word){

		if(word.length() == 0){
			return true;
		}

		if(check(x,y,board) && board[x][y] != '#' && board[x][y] == word.charAt(0)){

			char temp = board[x][y];
			//word = word.substring(1);
			board[x][y] ='#';

			if(check(x,y+1,board) && dfs(board,x,y+1,word.substring(1))){
				return true;
			}

			if(check(x,y-1,board) && dfs(board, x,y-1,word.substring(1))){
				return true;
			}

			if(check(x+1,y,board) && dfs(board, x+1, y, word.substring(1))){
				return true;
			}

			if(check(x-1,y,board)&&dfs(board, x-1, y, word.substring(1))){
				return true;
			}
			board[x][y] = temp;
			return false;
		}
		return false;
	}

	public boolean check(int x, int y, char[][]board){
		int m = board.length;
		int n = board[0].length;

		if(x>=0 && x<m && y >=0 && y < n){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		char[][] board = {{'A','B','C','E'},
				  {'S','F','C','S'},
				  {'A','D','E','E'}};
		
		WordSearch ws = new WordSearch();
		System.out.println(ws.exist(board,"ABCCED"));

	}

}
