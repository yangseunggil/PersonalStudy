package lamdaExpression;

public class ExOfLambda {

	@FunctionalInterface
	interface Cal{
		int add(int a, int b);
	}
	
	public static void main(String args[]){
		
		Cal cal = (int a, int b) -> a+b;
		
		System.out.println(cal.add(1, 2));
		
	} // end of main
	
}// end of ExOfLambda
