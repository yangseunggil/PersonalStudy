package javaTheory.threadAndExecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExOfScheduledExecutorService {

	public static void main(String args[]) {
		
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

		Runnable task = () -> System.out.println("Scheduling: " + System.nanoTime());

		int initialDelay = 0;
		int period = 2;
		executor.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.SECONDS);
		
		
	}
}
