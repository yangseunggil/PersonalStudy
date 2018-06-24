package algorithm.baek;

import java.util.Scanner;

/**
 * [경로이동 최소 비용.]
 * https://www.acmicpc.net/problem/10971
 * 
 * 
 * [순열 활용문제]
 */

public class _022TravelingSalesmanProblem{
    public static void main(String args[]) {
    	// 입력
        Scanner sc = new Scanner(System.in);
        int cities = sc.nextInt();
        int[][] cost = new int[cities][cities];
        for(int i = 0 ; i < cities ; i ++){
        	for(int j = 0 ; j < cities ; j++){
        		cost[i][j] = sc.nextInt();;
        	}
        }        
        
        // 이동경로 지정
        int[] path = new int[cities-1];
        for(int i = 0; i < cities-1 ; i++){
        	path[i] = i+1;
        }
        
        int minimunCost = Integer.MAX_VALUE;
        do{
            int sumOfCost = 0;
            boolean noDirection = true;
            // 각 방향별 비용 합산
//            for(int i = 0 ; i < cities - 1 ; i ++){
            for(int i = 0 ; i < cities - 2 ; i ++){
            	if(cost[path[i]][path[i+1]]==0){
            		noDirection = false;
            	}else{
            		sumOfCost += cost[path[i]][path[i+1]];
            		
            	}
            }
            // 마지막 지점에서 출발지점으로 가는 비용까지 합산.
//            if(noDirection && cost[path[cities-1]][path[0]] != 0){
//            	sumOfCost += cost[path[cities-1]][path[0]];
//            	// 최소값 구분
//            	if(minimunCost > sumOfCost){
//            		minimunCost = sumOfCost;
//            	}
//            }
            if(noDirection && cost[0][path[0]] != 0 && cost[path[cities-2]][0] != 0 ){
            	sumOfCost += cost[0][path[0]] + cost[path[cities-2]][0];
            	// 최소값 구분
            	if(minimunCost > sumOfCost){
            		minimunCost = sumOfCost;
            	}
            }
             
        }while(hasNextPermutation(path));
       
        System.out.println(minimunCost);
        
        
        // 최초 정렬
        sc.close();
    }
    
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
    
}