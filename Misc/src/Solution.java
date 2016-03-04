import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
	public String[] exp(String n) {
		String [] twoParts = n.split("\\.");
		Deque res = new ArrayDeque();

		if(twoParts[0].length()!=0){
			int temp = Integer.parseInt(twoParts[0]);
			int places = 1;
			while(temp!=0){
				int x = temp%10;
				if(x!=0){
					res.addFirst(Integer.toString(x*places));
				}
				temp = temp /10;
				places *= 10;
			}
		}

		if(twoParts.length==2){
			String y = twoParts[1];
			int counter=0;
			while(y.length()!=0){

				if(y.charAt(0) != '0'){
					String aftDec=".";
					for(int i=counter;i>0;i--){
						aftDec = aftDec + "0";
					}
					aftDec = aftDec + y.charAt(0);
					res.addLast(aftDec);
					
				}
				y = y.substring(1);
				counter++;
			}
		}  
		String [] sol = new String[res.size()];
		int idx=0;
		while(!res.isEmpty()){
			sol[idx] = res.pollFirst().toString();
			idx++;
		}
		return sol;
	}
	
	
	public static String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM","MMMM","MMMMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String a = M[num/1000];
        String b = C[(num%1000)/100];
        String c = X[(num%100)/10];
        String d = I[num%10];
        
        return a + b + c + d;
    }
	
	
	
	private final String[] lessThan20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	private final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	private final String[] thousands = {"", "Thousand", "Million", "Billion"};

	public String numberToWords(int num) {
	    if (num == 0)
	        return "Zero";
	    int i = 0;
	    String words = "";

	    while (num > 0) {
	        if (num % 1000 != 0)
	            words = helper(num % 1000) + thousands[i] + " " + words;
	        num /= 1000;
	        i++;
	    }

	    return words.trim();
	}
	
	public String multiply(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        int[] products = new int[n1 + n2];
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';
                products[i + j + 1] += d1 * d2;
            }
        }
        int carry = 0;
        for (int i = products.length - 1; i >= 0; i--) {
            int tmp = (products[i] + carry) % 10;
            carry = (products[i] + carry) / 10;
            products[i] = tmp;
        }
        StringBuilder sb = new StringBuilder();
        for (int num : products) sb.append(num);
        while (sb.length() != 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.length() == 0 ? "0" : sb.toString();
    }

	private String helper(int num) {
	    if (num == 0)
	        return "";
	    else if (num < 20)
	        return lessThan20[num] + " ";
	    else if (num < 100)
	        return tens[num / 10] + " " + helper(num % 10);
	    else
	        return lessThan20[num / 100] + " Hundred " + helper(num % 100);
	}
	
	
	


	public static void main(String[] args) {
		Solution s = new Solution();
		//String [] temp = s.exp("1234567890.1234567890");

		/*for(String m : temp){
			System.out.print(m + " ");
		}
		*/
		
		//System.out.println(s.intToRoman(5379));

		//System.out.println(s.numberToWords(5441152));
		
		s.multiply("1412", "22");
	}
}