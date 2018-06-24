package algorithm.baek;

import java.util.Arrays;
import java.util.Scanner;

/**
 * [배열 사이 합산의 최대값.]
 * N개의 정수로 이루어진 배열 A가 주어진다. 이 때, 배열에 들어있는 정수의 순서를 적절히 바꿔서 다음 식의 최대값을 구하는 프로그램을 작성하시오.
 * |A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]|
 * 
 *  - 입력 1 : 배열 개수 (3~8)
 *  - 입력 2 : 배열내 입력할 값.
 *  - 출력 1 : 배열 사이 최대값.
 *  
 *  [순열 활용문제]
 *  1. 입력된 배열들 정렬.
 *  2. 각 케이스별로 반복문을 작성하여 최대값을 구한다.
 */

public class _021MaximumBetweenValue{
    public static boolean hasNextPermutation(int[] inputArray) {
        int i = inputArray.length-1;
        while (i > 0 && inputArray[i-1] >= inputArray[i]) {
            i -= 1;
        }

        // 마지막 순열이면 거짓 반환.
        if (i <= 0) {
            return false;
        }

        int j = inputArray.length-1;
        while (inputArray[j] <= inputArray[i-1]) {
            j -= 1;
        }

        // 순서 변경
        int temp = inputArray[i-1];
        inputArray[i-1] = inputArray[j];
        inputArray[j] = temp;

        j = inputArray.length-1;
        while (i < j) {
            temp = inputArray[i];
            inputArray[i] = inputArray[j];
            inputArray[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }
    
    // 사이 합산값 계산
    public static int getSumOfBetweenValues(int inputArray[]) {
        int sum = 0;
        for (int i=1; i<inputArray.length; i++) {
            sum += Math.abs(inputArray[i] - inputArray[i-1]);
        }
        return sum;
    }
    
    public static void main(String args[]) {
    	// 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] inputArray = new int[n];
        for (int i=0; i<n; i++) {
            inputArray[i] = sc.nextInt();
        }
        
        // 최초 정렬
        Arrays.sort(inputArray);
        
        int minimumValue = 0;
        
        // 최대값 계산
        do {
            int temp = getSumOfBetweenValues(inputArray);
            minimumValue = Math.max(minimumValue, temp);
        } while(hasNextPermutation(inputArray));

        System.out.println(minimumValue);
        sc.close();
    }
}