package algorithm.baek;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1107
// 어려움.
// 전수 탐색. 일일이 하나씩 확인하면서 탐색.
public class _019RemoteControlComment{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		// 고장난 버튼을 배열로 설정.
		boolean[] broken = new boolean[10];
		
		// 이동하려는 채널.
		int go = scanner.nextInt();
		
		// 현재 있는 채널.
		int present = 100;
		
		// 고장난 버튼
		int[] brokenButton;
		int brokenCount = scanner.nextInt();
		brokenButton = new int[brokenCount];
		
		for(int i = 0 ; i < brokenCount; i++){
			brokenButton[i] = scanner.nextInt();
			broken[brokenButton[i]] = true;
		}
		
		// 최초 입력 횟수 계산
		int inputCount = go - present;
		if(inputCount < 0 ){
			inputCount = -inputCount;
		}
		
		// 이동하려고 하는 채널 N (0 ≤ N ≤ 500,000)
		for(int i = 0 ; i < 500000 ; i++ ){
			int c = i;

			// C에 포함된 숫자중 고장난 버튼이 있는지 확인한다.
			int len = possible(c, broken);

			// 망가진 버튼이 없다면 
			if(len>0){
				
				// 이동하려는 채널과 현재 입력한 채널번호의 차를 구해서 +나 -를 몇 번 눌러야 하는지 계산.
				int press = c - go;
				if(press < 0){
					press = -press;
				}
				
				// 최초 입력 횟수보다 작으면 그 값으로 결과를 도출.
				if(inputCount > len + press){
					inputCount = len + press;
				}
			}
			
		}
		System.out.println(inputCount);
		
		scanner.close();
	}
	
	// 이동하려는 채널번호(c)에 고장난 버튼이 있으면 0, 없으면 버튼입력 횟수를 반환.
	public static int possible(int c, boolean[] isBroken){
		if (c == 0) {
	        return isBroken[0] ? 0 : 1;
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