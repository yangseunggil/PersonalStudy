package algorithm.baek;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _005APlusB {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>();
		int A = 0;
		int B = 0;
		
		while(scanner.hasNextInt()){
			A = scanner.nextInt();
			B = scanner.nextInt();
			if(A <=0 || B>=10){
				scanner.close();
				break;
			}
			list.add(A+B);
		}
		for(int i = 0 ; i < list.size() ; i ++){
			System.out.println(list.get(i));
		}
		scanner.close();
	}
}
