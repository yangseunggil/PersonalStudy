package algorithm.baek;

import java.util.Scanner;

public class _003APlusB {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int A = scanner.nextInt();
		int B = scanner.nextInt();
		if(A <= 0 || B >=10){
			scanner.close();
			return;
		}
		System.out.println(A+B);
		scanner.close();
	}
}
