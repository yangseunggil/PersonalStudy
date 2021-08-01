package algorithm.fastcampus;

import java.util.ArrayList;
import java.util.Collections;

public class Chapter13InsertionSort {

    public ArrayList<Integer> sort(ArrayList<Integer> list){

//        for(int i = 1 ; i < list.size() -1 ; i ++){
//            for(int j = i ; j > 0; j --){
        for(int i = 0 ; i < list.size() -1 ; i ++){
            for(int j = i + 1 ; j > 0; j --){
                if(list.get(j-1) > list.get(j)){
                    Collections.swap(list, j, j-1);
                }else{
                    break;
                }
            }
        }
        return list;
    }

    public static void main(String[] args){
        Chapter13InsertionSort sort = new Chapter13InsertionSort();
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i = 0 ; i < 100 ; i ++){
            list.add(  (int) (Math.random()*100)  );
        }

        System.out.println(sort.sort(list));
    }






}
