package Parenthesis;

public class Snippet {
	public boolean isMatch(String s, String p) {  
		int i=0,j=0;  
		int star=-1;  
		int si=i;  
		while(i<s.length())  
		{  
			if(j<p.length())  
			{  
				if((p.charAt(j)=='?'||p.charAt(j)==s.charAt(i)))  
				{  
					i++;  
					j++;  
					continue;  
				}  
				if(p.charAt(j)=='*')  
				{  
					star=j++;  
					si=i;  
					continue;  
				}  
			}  
			if(star!=-1)  
			{  
				//j=star+1;  
				i=++si;  
				continue;  
			}  
			return false;  
		}  
		while(j<p.length()&&p.charAt(j)=='*')  
			j+=1;  
		return j==p.length();  
	}  

	public static void main(String[] args) {

		Snippet s=new Snippet();
		System.out.println(s.isMatch("gee", "g*k"));
	}
} 

