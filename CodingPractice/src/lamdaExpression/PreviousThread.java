package lamdaExpression;

public class PreviousThread {
	
	public static void main(String args[]){
		
		Thread thread = new Thread (new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("There is no rule without exception.");
			} // end of run
			
		}); // end of definition to thread variable
		
		thread.start();
		
	} // end of main
	
} // end of PreviousThread
