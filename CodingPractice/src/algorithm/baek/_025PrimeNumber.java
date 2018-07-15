package algorithm.baek;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _025PrimeNumber {
	  public static int change(int presentValue, int index, int digit) {
	        if (index == 0 && digit == 0) {
	            return -1;
	        }
	        String string = Integer.toString(presentValue);
	        StringBuilder sb = new StringBuilder(string);
	        sb.setCharAt(index, (char)(digit + '0'));
	        return Integer.parseInt(sb.toString());
	    }
	    public static void main(String args[]) {
	        Scanner sc = new Scanner(System.in);

	        /* 배열의 index가 소수인지 아닌지 지정하는 과정.
	         * 첫째. 1, 2, 3, 5 ... 는 소수다.
	         * 둘째. boolean[1]는 true를 출력한다.
	         **/
	        boolean[] primeNumber = new boolean[10001];
	        for (int i=2; i<=10000; i++) {
	            if (primeNumber[i] == false) {
	                for (int j=i*i; j<=10000; j+=i) {
	                    primeNumber[j] = true;
	                }
	            }
	        }
	        for (int i=0; i<=10000; i++) {
	            primeNumber[i] = !primeNumber[i];
	        }
	        
	        // 알고리즘 수행 횟수 지정.
	        int t = sc.nextInt();
	        while (t-- > 0) {
	        	
	        	// source 비밀번호
	            int source = sc.nextInt();
	            // target 비밀번호
	            int target = sc.nextInt();
	            
	            
	            boolean[] isPrime = new boolean[10001];
	            
	            /* source에서 target으로 변경하는 횟수.
	             * index : 현재 입력된 비밀번호.
	             * value : 변경 횟수.
	             * 
	             * ex : 1033에서 8179로 바꿀때.
	             * changeCount[1033]=0
	             * changeCount[8179]=6
	             */
	            int[] changeCount = new int[10001];
	            changeCount[source] = 0;
	            
	            // source는 당연히 소수이니 true로 지정.
	            isPrime[source] = true;
	            
	            /* 1. queue 가장 앞에 있는 비밀번호를 추출한다.
	             * 2. 추출한 값을 변경하여 그 값이 소수이면, queue에 적재한다.
	             * 3. 그 에 따라 변경횟수도 기억한다.
	             * 4. queue에서 추출한 값이 없을때 까지 반복.
	             */
	            Queue<Integer> q = new LinkedList<Integer>();
	            q.add(source);
	            while (!q.isEmpty()) {
	            	
	                int presentValue = q.remove();
	                
	                // 4자리마다 숫자 10개를 변경하면서 소수를 판단하고 queue에 적재 및 변경횟수를 기억한다.
	                for (int i=0; i<4; i++) {
	                    for (int j=0; j<=9; j++) {
	                        int next = change(presentValue, i, j);
	                        if (next != -1) {
	                            if (primeNumber[next] && isPrime[next] == false) {
	                                q.add(next);
	                                changeCount[next] = changeCount[presentValue] + 1;
	                                isPrime[next] = true;
	                            }
	                        }
	                    }
	                }
	            }
	            System.out.println(changeCount[target]);
	        }
	        sc.close();
	    }
}