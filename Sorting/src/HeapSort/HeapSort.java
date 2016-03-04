package HeapSort;

import java.util.ArrayList;

public class HeapSort {

	ArrayList<Integer> heap;
	public HeapSort() {
		// TODO Auto-generated constructor stub
		this.heap = new ArrayList<Integer>();
	}


	public void shiftUp(){
		int k = heap.size()-1;
		
		while(k>0){
			int p = (k-1)/2;	
			int item_k = heap.get(k);
			int item_p = heap.get(p);
			
			if(k<p){
				heap.set(k, item_p);
				heap.set(p, item_k);
				k = p;		
			}
			else{
				break;
			}
		}
	}
	
	
	public void siftDown(){
		int k =0;
		int r = 0,l=0,max=0;
		while(k<heap.size()){
			l = 2*k+1;
			r++; 
			max = l;
			if(r<heap.size()){
				if(heap.get(r)>heap.get(l)){
					max=r;
				}
			}
			if(heap.get(k)<heap.get(max)){
				heap.set(k, heap.get(max));
				heap.set(max, heap.get(k));
				k = max;
			}
			else{
				break;
			}
				
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
