package algorithm.baek;

import java.util.Scanner;

public class _011PrintTenBytes {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		final int PRINT_BYTE = 10;
		String N = scanner.nextLine();
		for(int i = 0 ; i < N.length()/PRINT_BYTE + 1 ; i ++ ){
			try{
				System.out.println( N.substring( i*PRINT_BYTE, (i+1)*PRINT_BYTE));
			}catch(IndexOutOfBoundsException e){
				System.out.println( N.substring( i*PRINT_BYTE, N.length()));
			}
		}
		scanner.close();
	}
}

