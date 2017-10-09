package javaTheory.threadAndExecutor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExOfTimeout {

	public static void main(String args[]) {
		ExecutorService executor = Executors.newFixedThreadPool(1);

		Future<Integer> future = executor.submit(() -> {
		    try {
		        TimeUnit.SECONDS.sleep(2);
		        return 123;
		    }
		    catch (InterruptedException e) {
		        throw new IllegalStateException("task interrupted", e);
		    }
		});

		try {
			future.get(1, TimeUnit.SECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
