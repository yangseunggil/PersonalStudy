package algorithm.fastcampus;

import java.util.ArrayList;
import java.util.Collections;

public class Chapter12SelectionSort {

    public ArrayList<Integer> sort(ArrayList<Integer> list){
        int minIdx;
        for(int i = 0 ; i < list.size() -1 ; i ++){
            minIdx = i;
            for(int j = i + 1; j < list.size() ; j ++){
                if(list.get(minIdx) > list.get(j)){
                    minIdx = j;
                }
            }
            Collections.swap(list, minIdx, i);
        }
        return list;
    }

    public static void main(String[] args){
        Chapter12SelectionSort sort = new Chapter12SelectionSort();
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i = 0 ; i < 100 ; i ++){
            list.add(  (int) (Math.random()*100)  );
        }

        System.out.println(sort.sort(list));
    }






}
