import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        HashMap<Character, Integer> lookup = new HashMap<Character, Integer>();
        
        int max= 0;
        for(int i=0, j=0;i<s.length();i++){
            if(lookup.containsKey(s.charAt(i))){
                j = Math.max(j,lookup.get(s.charAt(i))+1);
            }
            
            lookup.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
            
        }
        return max;
    }
    
    public static void main(String[] args) {
		Solution s = new Solution();
		int x =s.lengthOfLongestSubstring("abcabcbb");
		System.out.println(x);
	}
}