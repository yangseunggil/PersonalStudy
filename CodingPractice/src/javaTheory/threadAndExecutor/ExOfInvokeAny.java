package javaTheory.threadAndExecutor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExOfInvokeAny {

	public static Callable<String> callable(String result, long sleepSeconds) {
	    return () -> {
	        TimeUnit.SECONDS.sleep(sleepSeconds);
	        return result;
	    };
	}
	
	public static void main(String args[]) {
		
		ExecutorService executor = Executors.newWorkStealingPool();

		List<Callable<String>> callables = Arrays.asList(
		    callable("task1", 2),
		    callable("task2", 1),
		    callable("task3", 3));

		String result = null;
		try {
			result = executor.invokeAny(callables);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);

		// => task2
	}
	

}
