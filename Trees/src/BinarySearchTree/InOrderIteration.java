/**
 * 
 */
package BinarySearchTree;
import java.util.*;

/**
 * @author Ajinkya
 *
 */
public class InOrderIteration {

	
	public void InOrder(Node root){
		
		Stack<Node> stack = new Stack<Node>();
		
		while(true){
			if(root!=null){
				stack.push(root);
				root = root.left;
			}
			else{
				if(!stack.isEmpty()){
					root = stack.pop();
					System.out.print(root.value + "\t");
					root = root.right;
				}
				else{
					break;
				}
			}
		}
		//return root;
	}

}
