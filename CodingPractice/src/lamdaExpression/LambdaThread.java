package lamdaExpression;

public class LambdaThread {

	public static void main(String args[]){
		
		Thread thread = new Thread(() ->{
			System.out.println("There is no rule without exception.");
		});
		
		thread.start();
		
	} // end of main
	
}// end of LambdaThread
