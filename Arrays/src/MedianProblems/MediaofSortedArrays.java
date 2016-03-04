package MedianProblems;

public class MediaofSortedArrays {
	
	public int median(int [] array1, int[] array2){
		
		int pointer_a1=0, pointer_a2=0;
		int count = 0, n = array1.length;
		int m1=-1, m2=-1;
		
		while(count <= n){
			
			if(pointer_a1 == n){
				m1 = m2;
				m2 = array2[0];
				break;
			}
			if(pointer_a2 == n){
				m1 = m2;
				m2 = array1[0];
				break;
			}
			if(array1[pointer_a1] < array2[pointer_a2]){
				m1 = m2;
				m2 = array1[pointer_a1];
				pointer_a1++;
			}
			else if(array1[pointer_a1] > array2[pointer_a2]){
				m1 = m2;
				m2 = array2[pointer_a2];
				pointer_a2++;
			}	
			count++;
		}
		return (m1+m2)/2;
	}
	
	public static void main(String[] args) {
		int [] a1 = {8,19,41,45};
		int [] a2 = {1,5,17,21};
		
		MediaofSortedArrays m = new MediaofSortedArrays();
		int medi = m.median(a1, a2);
		System.out.println(medi);
	}

}
