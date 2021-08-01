package algorithm.fastcampus;

import java.util.*;

public class Chapter12BubbleSort {

    public ArrayList<Integer> sort(ArrayList<Integer> list){
        for(int i = 0 ; i < list.size() - 1 ; i ++){
            boolean isSwapped = false;


            for (int j = 0 ; j < list.size() - 1 - i ; j++){
                if(list.get(j) > list.get(j+1)){
                    Collections.swap(list, j ,j+1);
                    isSwapped = true;
                }
            }

            if(!isSwapped){
                break;
            }
        }
        return list;
    }

    public static void main(String[] args){
        Chapter12BubbleSort sort = new Chapter12BubbleSort();
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i = 0 ; i < 100 ;i ++){
            list.add( (int)(Math.random()*100) );
        }
        System.out.println(sort.sort(list));
    }
}
