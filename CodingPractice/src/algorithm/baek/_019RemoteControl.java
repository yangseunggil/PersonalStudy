package algorithm.baek;

import java.util.Scanner;

public class _019RemoteControl{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int go = s.nextInt();
		int now = 100;
		
		int brkCnt = s.nextInt();
		int[] brkBtn = new int[brkCnt];
		boolean[] isBrk = new boolean[10]; 
		for(int i = 0 ; i < brkCnt ; i++) {
			brkBtn[i] = s.nextInt();
			isBrk[brkBtn[i]] = true;
		}
		
		int rst = go - now;
		if(rst < 0) {
			rst = -rst;
		}
		
		for(int N = 0 ; N <= 500000 ; N ++) {
			int c = N;
			int inCnt = 0;
			while (c > 0) {
				if(isBrk[c%10]) {
					inCnt = 0;
					break;
				}
				inCnt++;
				c /= 10;
			}
			
			if(inCnt > 0) {
				int tmpRst = go - N;
				if(tmpRst < 0) {
					tmpRst = -tmpRst;
				}
				tmpRst = tmpRst + inCnt;
				if(rst > tmpRst)
					rst = tmpRst;
			}
		}
		System.out.println(rst);
		s.close();
	}
}