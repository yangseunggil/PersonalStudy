package algorithm.baek;

import java.util.Scanner;

public class _007APlusB {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int line = scanner.nextInt();
		int[] returnValues = new int[line];
		int A = 0;
		int B = 0;
		for(int i = 0 ; i < line ; i++){
			A = scanner.nextInt();
			B = scanner.nextInt();
			if(A <= 0 || B >= 10){
				scanner.close();
				return;
			}
			returnValues[i] = A+B;
		}
		for(int i = 0 ; i < line ; i++){
			System.out.println("Case #" + (i+1) + ": " + returnValues[i]);
		}
		
		scanner.close();
	}
}