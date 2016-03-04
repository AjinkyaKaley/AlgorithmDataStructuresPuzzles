package QuickSort;

public class QuickSort {
	
	public void quicksort(int [] input, int low, int high){
        // 1 3 9 8 2 7 5
        // 1 3 2 8 9 7 5
		// 1 3 2 5 9 7 8
        if(low == high || low > high){
            return;
        }
        int pivot = input[high];
        int aux_high = high;
        high--;
        int aux_low = low;
        while(true){
        	
            while(input[low] < pivot && low <input.length){
                low++;
            }
            
            while(high >= 0 && input[high] > pivot ){
                high--;
            }
            
            if(low < high){
            	swap(input, low, high);
            	/*input[low] = input[low] ^ input[aux_high];
                input[aux_high] = input[low] ^ input[aux_high];
                input[low] = input[low] ^ input[aux_high];*/
            }
            else{
            	int temp = input[aux_high];
            	input[aux_high] = input[low];
            	input[low] = temp;
                break;
            }
        }
        //System.out.println(low + " " + high);
       
        
        
        quicksort(input,aux_low,low-1);
        quicksort(input,low+1,aux_high);   
        for(int i=0;i<input.length;i++){
			System.out.print(input[i]+" ");
		}
    }
	
	
/*public void quicksort(int[] input, int low, int high){
        
        int pivot =  input[high];
        int k = partition(input, low, high);
        
        if(low < k-1){
            quicksort(input,low,k-1);
        }
        
        else if(k < high){
            quicksort(input,k,high);
        }
    }
    */
    /*public int partition(int[] input, int low, int high){
        int pivot = input[high];
        while(low < high){
            // {1,3,9,8,2,7,5};
            while(input[low] < pivot ){
                low++;
            }
            
            while(input[high] > pivot){
                high--;
            }
            
            if(low<high){
                
            	int temp = input[low];
            	input[low] = input[high];
            	input[high] = temp;
                low++;
                high--;
            }
            
            for(int i=0;i<input.length;i++){
    			System.out.print(input[i]+" ");
    			
    		}
            System.out.println();
        }

        
        return low;
    }*/
	
	
	 static void printArray(int[] ar) {
         for(int n: ar){
            System.out.print(n+" ");
         }
           System.out.println("");
      }
       
	 
	 
	 static void partition(int[] ar) {
	        
	        if(ar.length==0){
	            printArray(ar);
	        }
	        int pivot = ar[0];
	        
	        int low = 1;
	        int high = ar.length-1;
	        
	        while(low < high){
	            
	            while(ar[low]<pivot){
	                low++;
	            }
	            
	            while(ar[high]>pivot){
	                high--;
	            }
	            
	            if(low < high){
	                int temp = ar[low];
	                ar[low] = ar[high];
	                ar[high] = temp;
	            }
	        }
	        
	        int temp = ar[0];
	        ar[0] = ar[high];
	        ar[high] = temp;
	        
	        printArray(ar);
	 }
	


	public void swap(int[] input, int low, int high){
		
		input[low] = input[low] ^ input[high];
		input[high] = input[low] ^ input[high];
		input[low] = input[low] ^ input[high];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] x = {4,5,3,7,4,2};
		QuickSort q = new QuickSort();
		q.partition(x);
	/*	for(int i=0;i<x.length;i++){
			System.out.print(x[i]+" ");
		}*/

	}

}
