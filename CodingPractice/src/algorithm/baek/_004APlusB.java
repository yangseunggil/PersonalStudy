package algorithm.baek;

import java.util.Scanner;

public class _004APlusB {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int line = scanner.nextInt();
		int[] returnValues = new int[line];
		for(int i = 0 ; i < line ; i ++){
			returnValues[i] = scanner.nextInt() + scanner.nextInt();
		}
		for(int i = 0 ; i < line ; i ++){
			System.out.println(returnValues[i]);
		}
		scanner.close();
	}
}