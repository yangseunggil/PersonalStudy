package javaTheory.threadAndExecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ExOfscheduleAtFixedRate {

	public static void main(String args[]) {
		
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

		Runnable task = () -> System.out.println("\nScheduling: " + System.nanoTime());
		ScheduledFuture<?> future = executor.schedule(task, 3, TimeUnit.SECONDS);

		try {
			TimeUnit.MILLISECONDS.sleep(1337);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
		System.out.printf("Remaining Delay: %sms", remainingDelay);
		
		
	}
}
