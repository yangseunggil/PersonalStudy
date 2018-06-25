package algorithm.baek;

import java.util.Scanner;

public class _010SumOfNumbers {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);	
		String input = null; 
		int N = scanner.nextInt();
		int returnValue = 0;
		if(1 > N || N > 100){
			scanner.close();
			return;
		}
		input = scanner.next();
		if(!(input.length()==N)){
			scanner.close();
			return;
		}
		for(int i = 0 ; i < input.length() ; i++){
			returnValue += Character.getNumericValue(input.charAt(i));
		}
		System.out.println(returnValue);
		
		
		scanner.close();
	}
}

