package GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {


	public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {

		HashMap<String, ArrayList<Pair>> lookup = new HashMap<String, ArrayList<Pair>>();
		ArrayList<ArrayList<Integer>> sol = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<a.size();i++){
			String str = a.get(i);
			char [] x = str.toCharArray();
			Arrays.sort(x);
			String s = new String(x);
			if(!lookup.containsKey(s)){
				ArrayList<Pair> temp = new ArrayList<Pair>();
				Pair p = new Pair(str,i);
				temp.add(p);
				lookup.put(s,temp);
			}
			else{
				ArrayList<Pair> t = lookup.get(s);
				Pair p = new Pair(str,i);
				t.add(p);
			}
		}

		// cat dog god tca
		for(String str : a){

			char[] x = str.toCharArray();
			Arrays.sort(x);
			String s = new String(x);
			if(!lookup.isEmpty() && lookup.containsKey(s)){

				
				ArrayList<Integer> ar=new ArrayList<Integer>();
				if(lookup.containsKey(s)){
					ArrayList<Pair> t = lookup.get(s);
					int idx1 = t.get(0).index;
					int idx2 = t.get(t.size()-1).index;
					if(idx1 == idx2){
						ar.add(idx1);
					}
					else{
						ar.add(idx1+1);
						ar.add(idx2+1);
					}

					lookup.remove(s);
				}
				sol.add(ar);
			}
		}
		return sol;
	}


	class Pair{
		String val;
		int index;

		public Pair(String str, int i){
			val = str;
			index = i;
		}
	}


	public static void main(String[] args) {
		List<String> t = new ArrayList<String>();
		t.add("cat");
		t.add("dog");
		t.add("god");
		t.add("act");
		t.add("AJIN");

		GroupAnagrams gp = new GroupAnagrams();
		ArrayList<ArrayList<Integer>> list = gp.anagrams(t);

		for(ArrayList<Integer> a : list){
			for(int i:a){
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
