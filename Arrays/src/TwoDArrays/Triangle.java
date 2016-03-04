package TwoDArrays;

import java.util.ArrayList;
import java.util.List;

public class Triangle {

	public int minimumTotal(List<List<Integer>> triangle) {

		List<Integer> mini = triangle.get(triangle.size()-1);

		for(int i = triangle.size()-2; i>=0; i--){
			List<Integer> temp = triangle.get(i);
			for(int j=0;j<temp.size();j++){
				int x = temp.get(j) + Math.min(mini.get(j),mini.get(j+1));
				mini.set(j, x);
			}
		}
		return mini.get(0);
	}
	
	public static void main(String[] args) {
		Triangle t = new Triangle();
		List<List<Integer>> temp = new ArrayList<List<Integer>>();
		ArrayList<Integer> one = new ArrayList<Integer>();
		one.add(1);
		
		ArrayList<Integer> two = new ArrayList<Integer>();
		two.add(2);
		two.add(3);
		
		temp.add(one);
		temp.add(two);
		System.out.println(t.minimumTotal(temp));
	}
}
