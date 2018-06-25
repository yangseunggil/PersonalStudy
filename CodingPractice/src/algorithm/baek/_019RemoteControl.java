package algorithm.baek;

import java.util.Scanner;

public class _019RemoteControl{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		boolean[] isBroken = new boolean[10];
		int toChannel = scanner.nextInt();
		int presentChannel = 100;
		int[] brokenButton;
		int brokenCount = scanner.nextInt();
		brokenButton = new int[brokenCount];
		
		for(int i = 0 ; i < brokenCount; i++){
			brokenButton[i] = scanner.nextInt();
			isBroken[brokenButton[i]] = true;
		}
		
		int inputCount = toChannel - presentChannel;
		if(inputCount < 0 ){
			inputCount = -inputCount;
		}
		
		for(int i = 0 ; i < 10000 ; i++ ){
			int c = i;
			int len = possible(c, isBroken);
			if(len>0){
				int press = c - toChannel;
				if(press < 0){
					press = -press;
				}
				if(inputCount > len + press){
					System.out.println(inputCount + ":" + len + ":" + press);
					inputCount = len + press;
				}
			}
			
		}
		System.out.println(inputCount);
		
		scanner.close();
	}
	
	public static int possible(int c, boolean[] isBroken){
		if (c == 0) {
	        if (isBroken[0]) {
	            return 0;
	        } else {
	            return 1;
	        }
	    }
	    int len = 0;
	    while (c > 0) {
	        if (isBroken[c % 10]) {
	            return 0;
	        }
	        len += 1;
	        c /= 10;
	    }
	    return len;
	};
	
	
}