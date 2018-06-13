package algorithm.baek;

import java.util.Scanner;

public class _002APlusB {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String[] split = input.split(" ");
		int[] value = new int[split.length];
		int returnValue = 0;
		for(int i = 0 ; i < value.length; i++){
			value[i] = Integer.parseInt(split[i]);
			returnValue += value[i];
		}
		System.out.println(returnValue);
		scanner.close();
	}
}
