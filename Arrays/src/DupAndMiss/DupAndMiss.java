package DupAndMiss;

import java.util.ArrayList;
import java.util.Collections;

public class DupAndMiss {



	public ArrayList<Integer> wave(ArrayList<Integer> a) {

		Collections.sort(a);
		doThis(a);
		return a;
	}


	public void doTheJob(ArrayList<Integer>a, int low, int high){

		if(low == high){
			return;
		}

		if(high - low == 1){
			// do the job
			if(a.get(low) > a.get(high)){
				return;
			}
			else{
				int temp = a.get(low);
				a.set(low, a.get(high));
				a.set(high,temp);
				return;
			}
		}

		int mid = (low + high)/2;
		doTheJob(a,low,mid);
		doTheJob(a,mid,high);
	}



	public void doThis(ArrayList<Integer>a){


		int first =0;
		int second =1;

		while(second<a.size()){
			if(second-first==1){
				if(a.get(first) > a.get(second)){
					first = second;
					second = second+1;
					continue;
				}
				else{
					int temp = a.get(first);
					a.set(first, a.get(second));
					a.set(second,temp);
					//return;
				}
			}

			first = second+1;
			second = second+2;

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DupAndMiss dp = new DupAndMiss();
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(5);
		a.add(1);
		a.add(3);
		a.add(2);
		a.add(4);
		dp.wave(a);
	}

}
