package algorithm.fastcampus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Chapter20Greedy {


    /**
     * 지불해야 하는 값이 4720원 일 때 1원 50원 100원, 500원 동전으로 동전의 수가 가장 적게 지불하시오.
     * 가장 큰 동전부터 최대한 지불해야 하는 값을 채우는 방식으로 구현 가능
     * 탐욕 알고리즘으로 매순간 최적이라고 생각되는 경우를 선택하면 됨
     */
    public void coin(Integer price, ArrayList<Integer> coinList){
        Integer totalCount = 0;
        Integer currentPrice = price;


        for(Integer coin : coinList){
            Integer dividedCount = currentPrice / coin;
            totalCount += dividedCount;
            currentPrice -= dividedCount * coin;
            System.out.println(coin + "원 동전 " + dividedCount + "개, " + dividedCount * coin + "원");
        }
        System.out.println("총 " + totalCount + "개");
    }

    /**
     * 부분 배낭 문제
     * 각 물건은 1개씩 있다.
     */
    public void fkp(Double capacity, Integer[][]objectList){
        double totalValue = 0.0;
        double fraction = 0.0;

        // 가치가 높은것 순으로 정렬
        Arrays.sort(objectList, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o2[1]/o2[0] - o1[1]/o1[0];
            }
        });

        for (int index = 0; index < objectList.length; index++) {
            if ( (capacity - (double)objectList[index][0]) > 0 ) {
                capacity -= (double)objectList[index][0];
                totalValue += (double)objectList[index][1];
                System.out.println("무게:" + objectList[index][0] + ", 가치:" + objectList[index][1]);
            } else {
                fraction = capacity / (double)objectList[index][0];
                totalValue += (double)objectList[index][1] * fraction;
                System.out.println("무게:" + objectList[index][0] + ", 가치:" + objectList[index][1] + ", 비율:" + fraction);
                break;
            }
        }
        System.out.println("총 담을 수 있는 가치:" + totalValue);
    }





    public static void main(String[] args){

        Chapter20Greedy gObject = new Chapter20Greedy();
        ArrayList<Integer> coinList = new ArrayList<Integer>(Arrays.asList(500, 100, 50, 1));
        gObject.coin(4720, coinList);

        Integer[][] objectList = { {10, 10}, {15, 12}, {20, 10}, {25, 8}, {30, 5} };
        gObject.fkp( 30.0, objectList);

    }

}
