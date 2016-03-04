package Parenthesis;

public class GenerateParenthesis {

	
	public void generateParaenthesis(String str, int n){
		
		if(str.length()==2*n){
			System.out.println(str);
			return;
		}
		
		else{
			int left = 0;
			int right = 0;
			
			for(int i=0;i<str.length();i++){
				if(str.charAt(i)=='('){
					left++;
				}
				
				if(str.charAt(i)==')'){
					right++;
				}
			}
			
			if(left == right){
				generateParaenthesis(str+"(", n);
			}
			else if(right<left){
				if(left<n){
					generateParaenthesis(str+"(", n);
				}
				generateParaenthesis(str+")", n);
				
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateParenthesis gp = new GenerateParenthesis();
		gp.generateParaenthesis("", 3);
	}

}
