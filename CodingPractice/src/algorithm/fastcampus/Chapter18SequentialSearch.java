package algorithm.fastcampus;

import java.util.ArrayList;
import java.util.Arrays;

public class Chapter18SequentialSearch {

    public int search(ArrayList<Integer> list, int data){
        for(Integer current : list){
            if(data == current){
                return list.indexOf(current);
            }
        }
        return -1;
    }



    public static void main(String[] args){
        ArrayList<Integer> testData = new ArrayList<Integer>();

        for (int index = 0; index < 100; index++) {
            testData.add((int)(Math.random() * 100));
        }
        Chapter18SequentialSearch search = new Chapter18SequentialSearch();
        System.out.println(testData);
        System.out.println(search.search(testData, 4));
    }

}
