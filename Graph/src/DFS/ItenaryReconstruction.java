package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class ItenaryReconstruction {


	public void reconstruct(HashMap<String,PriorityQueue<String>> iter){

		PriorityQueue<String> temp_process = iter.get("JFK");
		StringBuilder sb = new StringBuilder("JFK ");
		String curr = temp_process.poll();
		
		
		while(!iter.containsKey(curr)){
			curr = temp_process.poll();
		}
		sb.append(curr + " ");

		if(temp_process.size()==0){
			iter.remove("JFK");
		}

		while(!iter.isEmpty()){

			PriorityQueue<String> temp = iter.get(curr);

			String prev = curr;
			
			curr = temp.poll();
			
			while(!iter.containsKey(curr) && iter.size()!=1){
				curr = temp.poll();
			}
			
			sb.append(curr + " ");

			if(temp.size()==0){
				iter.remove(prev);
			}

			System.out.println(sb.toString());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// [["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
		// [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
		// [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
		String [][] tickets = {{"JFK", "KUL"},{"JFK", "NRT"},{"NRT","JFK"}};
		//String [][] tickets = {{"MUC","LHR"},{"JFK","MUC"},{"SFO","SJC"},{"LHR","SFO"}};
		//String [][] tickets = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
		
		HashMap<String, PriorityQueue<String>> entry = new HashMap<String, PriorityQueue<String>>();

		for(String [] str : tickets){
			if(!entry.containsKey(str[0])){				
				PriorityQueue<String> temp = new PriorityQueue<String>();
				temp.add(str[1]);

				entry.put(str[0], temp );
			}
			else{
				PriorityQueue<String> t = entry.get(str[0]);
				t.add(str[1]);
				entry.put(str[0], t);
			}
		}

		ItenaryReconstruction it = new ItenaryReconstruction();
		it.reconstruct(entry);
	}

}
