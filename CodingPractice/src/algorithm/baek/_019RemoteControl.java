package algorithm.baek;

import java.util.Scanner;

/**
 * [이동하고자 하는 채널에 대하여 최소 리모컨 입력횟수를 구하는 문제.]
 *  - 리모컨에 0 ~ 9 버튼과 +,- 버튼이 있음.
 *  - 현재 채널은 100번에 있음.
 *  - 채널은 0번에서 50만번 까지임.
 *  - 입력 1 : 이동하고자 하는 채널 - 목표채널이라 지칭.
 *  - 입력 2 : 고장난 숫자버튼 개수.
 *  - 입력 3 : 고장난 숫자버튼.
 *  - 출력 1 : 최소 입력 횟수.
 *  
 *  1. 모든 채널 번호들에 대하여 입력 횟수를 확인한다. 이를 경우의수라 지칭하겠다.
 *  2. 고장난 버튼을 제외하고 경우의수를 입력하기 위해
 *     숫자만으로 버튼 입력 횟수를 파악한다.
 *  3. 목표채널과 경우의 수의 차이를 구한다.
 *     그 값은 경우에 수에서 목표채널로 가기 위한 +,- 버튼의 입력횟수 의미한다.
 *  4. 2와 3을 더하면 목표채널로 가기위한 버튼 입력횟수를 구할 수 있다.
 *  
 *  5. 1에서 언급한 모든 채널에 대한 입력횟수를 파악하는 논리이기 때문에
 *     매번 4에서 나온 값은 이전에 케이스에서 구한 4의 값과 비교를 하는 것이다.
 *  6. 참고로 1을 시작하기 전에 주어진 조건은 현재 채널이 100이 있다.
 *     때문에 목표채널과 100의 차이 값을 최초에 구해두고 1부터 실행 하는 논리도 있다.
 */

public class _019RemoteControl{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		boolean[] isBroken = new boolean[10];
		int toMoveChannel = scanner.nextInt();
		int presentChannel = 100;
		int[] brokenButton;
		int brokenCount = scanner.nextInt();
		brokenButton = new int[brokenCount];
		
		// 고장난 버튼 입력
		for(int i = 0 ; i < brokenCount; i++){
			brokenButton[i] = scanner.nextInt();
			isBroken[brokenButton[i]] = true;
		}
		
		/** 최초, 현재 위치하고 있는 채널과 이동하고자 하는 채널의 차수를 구하여
		 * 입력횟수를 먼저 구해둔다.
		 * 가령 현재 채널이 100번이고 이동 채널이 101번이면
		 * +버튼 1번만 누르면 되는 케이스가 있을 수 있기 때문  
		 */
		int inputCount = toMoveChannel - presentChannel;
		if(inputCount < 0 ){
			inputCount = -inputCount;
		}
		
		/**
		 * 최소 채널번호 0번부터 최대 채널번호 50만번 까지의 모든 경우의 수를 계산한다.
		 * 이를 caseNumber로 지칭하겠다.
		 * 1. 고장난 버튼을 기반으로, caseNumber에 대하여, 숫자버튼만으로 입력할 수 있는 횟수를 구한다.
		 * 2. caseNumber와 이동채널의 차이를 구하면 +,-버튼의 이동횟수를 구할 수 있다.
		 * 1, 2에서 나온 값을 합하면 최종 버튼 입력 횟수를 구할 수 있다.
		 */
		for(int i = 0 ; i < 500000 ; i++ ){
			int caseNumber = i;
			
			// 고장난 버튼을 제외한 숫자 버튼으로 입력한 횟수.
			int numberInputCount = numberInputCount(caseNumber, isBroken);
			
			if(numberInputCount>0){
				// +,- 버튼의 입력횟수를 구한다.
				int press = caseNumber - toMoveChannel;
				if(press < 0){
					press = -press;
				}
				
				if(inputCount > numberInputCount + press){
					inputCount = numberInputCount + press;
				}
			}
		}
		System.out.println(inputCount);
		
		scanner.close();
	}
	
	/** 숫자버튼 입력 횟수를 구하는 메소드
	 *  @param channelNumber : 이동하고자 하는 채널 번호
	 *  @param isBroken : 고장난 버튼 확인.
	 *  @return toMoveChannel에 고장난 버튼이 있으면 0, 그렇지 아니하면 버튼 입력 횟수.
	 */
	public static int numberInputCount(int channelNumber, boolean[] isBroken){
		if (channelNumber == 0) {
	        if (isBroken[0]) {
	            return 0;
	        } else {
	            return 1;
	        }
	    }
	    int inputCount = 0;
	    /* 한 자리수마다 고장난 버튼이 있는지 확인한다. 
	     * 단 하나의 숫자라도 고장난 버튼이 있으면 0을 리턴하고
	     * 그렇지 아니하면 버튼 입력횟수를 입력한다.
	     */
	    while (channelNumber > 0) {
	        if (isBroken[channelNumber % 10]) {
	            return 0;
	        }
	        inputCount += 1;
	        channelNumber /= 10;
	    }
	    return inputCount;
	};
	
	
}