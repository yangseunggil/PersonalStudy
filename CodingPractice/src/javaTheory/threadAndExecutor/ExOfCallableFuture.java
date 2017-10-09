package javaTheory.threadAndExecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExOfCallableFuture {

	public static void main(String args[]) {
		Callable<Integer> task = () -> {
			try {
				TimeUnit.SECONDS.sleep(1);
				return 123;
			} catch (InterruptedException e) {
				throw new IllegalStateException("task interrupted", e);
			}
		};

		ExecutorService executor = Executors.newFixedThreadPool(1);
		Future<Integer> future = executor.submit(task);

		System.out.println("future done? " + future.isDone());

		Integer result = null;
		try {
//			executor.shutdownNow();
			result = future.get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("future done? " + future.isDone());
		System.out.print("result: " + result);

	}

}
