package algorithm.baek;

import java.util.Scanner;

public class _008APlusB {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		int[] A = new int[T];
		int[] B = new int[T];
		int[] C = new int[T];
		for(int i = 0 ; i < T ; i++){
			A[i] = scanner.nextInt();
			B[i] = scanner.nextInt();
			if(A[i] <= 0 || B[i] >= 10){
				scanner.close();
				return;
			}
			C[i] = A[i]+B[i];
		}
		for(int i = 0 ; i < T ; i++){
			System.out.println("Case #" + (i+1) + ": " + A[i] + " + " + B[i] + " = " + C[i]);
		}
		
		scanner.close();
	}
}