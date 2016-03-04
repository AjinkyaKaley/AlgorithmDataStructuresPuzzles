package ParaenthesisMatching;

import java.util.Stack;

public class ParenthesisMatching {
	public Stack<Character> stack;
	
	public ParenthesisMatching(){
		stack = new Stack<Character>();
	}
	
	public boolean verifyParenthesis(String expression){
		int count = 0;
		for(int i=0; i<expression.length(); i++){
			char brace = expression.charAt(i);
			
			if( (brace == ')' || brace == '}')&& stack.isEmpty()){
				return false;
			}
			if(brace == '(' || brace == '{'){
				stack.push(brace);
			}
			else if(brace == ')' || brace == '}'){
				stack.pop();
			}
		}
		
		if(stack.isEmpty()){
			return true;
		}
		return false;
	}

	
	public boolean checkParenthisiNoSpace(String expr){
		int counter = 0;
		
		for(int i=0;i<expr.length();i++){
			
			if(expr.charAt(i) == '(' || expr.charAt(i) == '{'){
				counter++;
			}
			else if(expr.charAt(i)==')' || expr.charAt(i) == '}'){
				counter--;
			}
		}
		
		if(counter!=0){
			return false;
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s ="{(1*(2+3)/(4*5))";
		ParenthesisMatching p = new ParenthesisMatching();
		System.out.println(p.checkParenthisiNoSpace(s));
	}

}
