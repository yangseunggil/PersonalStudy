package algorithm.fastcampus;

import java.util.ArrayList;
import java.util.Arrays;

public class Chapter17QuickSort {

    public ArrayList<Integer> sort(ArrayList<Integer> list){
        if(list.size() <= 1){
            return list;
        }
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();
        int pivot = list.get(0);

        for(int i=1 ; i<list.size() ; i++ ){
            int currentData = list.get(i);
            if(pivot < currentData){
                right.add(currentData);
            }else{
                left.add(currentData);
            }
        }

        ArrayList<Integer> merged = new ArrayList<Integer>();
        merged.addAll(this.sort(left));
        merged.addAll(Arrays.asList(pivot));
        merged.addAll(this.sort(right));
        return merged;
    }


    public static void main(String[] args){
        ArrayList<Integer> testData = new ArrayList<Integer>();

        for (int index = 0; index < 100; index++) {
            testData.add((int)(Math.random() * 100));
        }
        Chapter17QuickSort mSort = new Chapter17QuickSort();
        System.out.println(mSort.sort(testData));
    }

}
