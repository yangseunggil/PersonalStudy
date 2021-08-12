package algorithm.fastcampus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Chapter18SequentialSearch {

    public boolean search(ArrayList<Integer> list, int data){

        if(list.size() == 1 && list.get(0) == data){
            return true;
        }
        if(list.size() == 1 && list.get(0) != data){
            return false;
        }
        if(list.size() == 0){
            return false;
        }

        int mid = list.size()/2;
        if(list.get(mid) == data){
            return true;
        }else if( list.get(mid) > data ){
            // left
            return this.search( new ArrayList<Integer>(list.subList(0,mid)), data );
        }else if ( list.get(mid) < data ){
            // right
            return this.search( new ArrayList<Integer>(list.subList(mid, list.size())), data );
        }else{
            return false;
        }
    }



    public static void main(String[] args){
        ArrayList<Integer> testData = new ArrayList<Integer>();

        for (int index = 0; index < 100; index++) {
            testData.add((int)(Math.random() * 100));
        }
        Collections.sort(testData);
        Chapter18SequentialSearch search = new Chapter18SequentialSearch();
        System.out.println(testData);
        System.out.println(search.search(testData, 4));
    }

}
