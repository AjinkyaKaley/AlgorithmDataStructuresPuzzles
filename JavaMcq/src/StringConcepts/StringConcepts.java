package StringConcepts;

public class StringConcepts {
	int i , j;
	public StringConcepts() {
		// TODO Auto-generated constructor stub
		i = 10;
		
	}
	public static void main(String[] args) {
		
		 String Str = new String("Welcome to Tutorialspoint.com");

	      System.out.print("Return Value :" );
	      System.out.println(Str.substring(0,0) );

	      System.out.print("Return Value :" );
	      System.out.println(Str.substring(10, 15) );
	}
}
