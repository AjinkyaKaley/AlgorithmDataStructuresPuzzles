package BinarySearchTree;

import java.util.Stack;

public class PreOrderSquenceValidation {

	
	public boolean preOrderValidation(String seq){
		
		String [] pre = seq.split(",");
		Stack<String> stc = new Stack<String>();
		int index = 0;
		
		for(int i=0;i<pre.length;i++){
			
			stc.push(pre[i]);
			
			while(endsWithTwoHashes(stc)){
				stc.pop();
				stc.pop();
				stc.pop();
				stc.push("#");
			}
		}
		
		if(stc.size()==1 && stc.peek().equals("#")){
			return true;
		}
		return false;
		
	}
	private boolean endsWithTwoHashes(Stack<String> stc) {
		// TODO Auto-generated method stub
		String temp = stc.pop();
		
		if(!stc.isEmpty() && stc.peek().equals("#") && temp.equals("#")){
			stc.push(temp);
			return true;
		}
		stc.push(temp);
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		PreOrderSquenceValidation p = new PreOrderSquenceValidation();
		System.out.println(p.preOrderValidation("9,3,4,#,#,1,#,#,2,#,6,#,#"));
	}

}
