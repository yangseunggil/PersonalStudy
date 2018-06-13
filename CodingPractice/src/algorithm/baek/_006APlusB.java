package algorithm.baek;

import java.util.Scanner;

public class _006APlusB {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String inputLine = null;
		String[] split = null;
		int line = Integer.parseInt(scanner.nextLine());
		int[] returnValues = new int[line];
		int A=0;
		int B=0;
		for(int i = 0 ; i < line ; i ++){
			inputLine = scanner.nextLine();
			split = inputLine.split(",");
			A = Integer.parseInt(split[0]);
			B = Integer.parseInt(split[1]);
			if(A <= 0 || B >= 10){
				scanner.close();
				return;
			}
			returnValues[i] = A+B;
		}
		for(int i = 0 ; i < line ; i ++){
			System.out.println(returnValues[i]);
		}
		scanner.close();
	}
}