package algorithm.fastcampus;

public class Chapter15Strategy {

    /**
     * Divide and Conquer
     * 문제를 나눌 수 없을 때까지 나누어서 각각을 풀면서 다시 합병하여 문제의 답을 얻는 알고리즘
     * 하양식 접근법으로, 상위의 해답을 구하기 위해, 아래로 내려가면서 하위의 해답을 구하는 방식
     * 일반적으로 재귀함수로 구현
     * 문제를 잘게 쪼갤 때, 부분 문제는 서로 중복되지 않음
     * 예: 병합 정렬, 퀵 정렬 등
     * 부분 문제는 서로 중복되지 않음
     * Memoization 기법 사용 안함
     *
     */
    public int finonacci_DC(int number){
        /*
        if(number == 0){
            return 0;
        }else if(number ==1){
            return 1;
        }
        */
        if(number <= 1){
            return number;
        }
        return finonacci_DC(number -1 ) + finonacci_DC(number -2 );
    }


    /**
     * 입력 크기가 작은 부분 문제들을 해결한 후, 해당 부분 문제의 해를 활용해서, 보다 큰 크기의 부분 문제를 해결, 최종적으로 전체 문제를 해결하는 알고리즘
     * 상향식 접근법으로, 가장 최하위 해답을 구한 후, 이를 저장하고, 해당 결과값을 이용해서 상위 문제를 풀어가는 방식
     * Memoization 기법을 사용함
     * Memoization (메모이제이션) 이란: 프로그램 실행 시 이전에 계산한 값을 저장하여, 다시 계산하지 않도록 하여 전체 실행 속도를 빠르게 하는 기술
     * 문제를 잘게 쪼갤 때, 부분 문제는 중복되어, 재활용됨
     * 예: 피보나치 수열
     * 부분 문제는 중복되어, 상위 문제 해결 시 재활용됨
     * Memoization 기법 사용 (부분 문제의 해답을 저장해서 재활용하는 최적화 기법으로 사용)
     *
     */
    public int finonacci_DP(int number){
        int[] cache = new int[number + 1];
        cache[0] = 0;
        cache[1] = 1;
        for (int index = 2; index < number + 1; index++) {
            cache[index] = cache[index - 1] + cache[index - 2];
        }
        return cache[number];
    }



    public static void main(String[] args){
        Chapter15Strategy factorial = new Chapter15Strategy();

        System.out.println(factorial.finonacci_DC(10));
        System.out.println(factorial.finonacci_DP(10));
    }






}
