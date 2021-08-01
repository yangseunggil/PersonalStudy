package algorithm.fastcampus;

import java.util.ArrayList;

public class Chapter14RecursiveCall {

    public int factorialFirst(int i){
//        if(i > 0){
        if(i > 1){
            return i * factorialFirst(i-1);
        }
        return 1;
    }

    public int factoricalSecond(int i){
        if( i < 1){
            return 1;
        }
        return i * factoricalSecond(i-1);
    }

    public int sum(ArrayList<Integer> list){
        if(list.size() <= 0){
            return 0;
        }
        int lastIdx = list.size() - 1;
//        return list.get(lastIdx) + sum(new ArrayList<Integer>(list.subList(0,lastIdx)));

        // or
         return list.get(0) + sum(new ArrayList<Integer>(list.subList(1,list.size())));
    }

    // 1,2,3으로 더할 수 있는 가지
    public int function(int number){
        if(number <= 1){
            return 1;
        }else if(number <=2){
            return 2;
        }else if(number <= 3){
            return 4;
        }
        return function(number - 1) + function(number - 2) + function(number - 3);
    }



    public static void main(String[] args){
        Chapter14RecursiveCall factorial = new Chapter14RecursiveCall();

//        System.out.println(factorial.factorialFirst(5));
//        System.out.println(factorial.factoricalSecond(5));

        /*
        ArrayList<Integer> list = new ArrayList<Integer>();
        for( int i = 1 ; i <= 5 ; i ++){
            list.add(i);
        }

        System.out.println(factorial.sum(list));
         */

        System.out.println(factorial.function(5));
    }






}
