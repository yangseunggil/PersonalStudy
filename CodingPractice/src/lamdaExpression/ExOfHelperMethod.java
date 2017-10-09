package lamdaExpression;

public class ExOfHelperMethod {

	interface Calculation {
		int go(int aaa, int bbb);
	} // end of Calculation
	
	static Calculation getCalculation(int ccc, int ddd){
		return (aaa, bbb)->{
			return aaa + bbb + ccc + ddd;
		};
	} // end of getCalculation

	public static void main(String args[]) {

		// aaa = 3
		// bbb = 4
		// ccc = 1
		// ddd = 2
		Calculation cal = getCalculation(1, 2);
		System.out.println(cal.go(3, 4));

	} // end of main

} // end of ExOfCharacter