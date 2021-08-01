package algorithm.fastcampus;

import java.util.ArrayList;

public class Chapter16MergeSort {

    public ArrayList<Integer> splitMerge (ArrayList<Integer> list){
        if(list.size() <= 1){
            return list;
        }
        int mid = list.size()/2;
        ArrayList<Integer> left = this.splitMerge(   new ArrayList<Integer>(list.subList(0, mid)) ); // 0 부터 medium - 1 인덱스 번호까지 해당 배열 아이템을 서브 배열로 추출
        ArrayList<Integer> right = this.splitMerge( new ArrayList<Integer>(list.subList(mid, list.size())) );

        return this.merge(left, right);
    }

    public ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right){
        ArrayList<Integer> merge = new ArrayList<Integer>();

        int leftIdx = 0;
        int rightIdx = 0;

//        while (true){
//            if(left.size() > leftIdx &&
//               right.size() > rightIdx){
//                break;
//            }

        // left, right 둘 다 있을 때
        while (left.size() > leftIdx && right.size() > rightIdx){
            if(left.get(leftIdx) > right.get(rightIdx) ){
                merge.add(right.get(rightIdx));
                rightIdx++;
            }else{
                merge.add(left.get(leftIdx));
                leftIdx++;
            }
        }

        // 다 정렬하고 left만 남을 때
        while(left.size() > leftIdx){
            merge.add(left.get(leftIdx));
            leftIdx++;
        }
        // 다 정렬하고 right만 있을 때
        while(right.size() > rightIdx){
            merge.add(right.get(rightIdx));
            rightIdx++;
        }

        return merge;
    }

    public static void main(String[] args){

        ArrayList<Integer> testData = new ArrayList<Integer>();

        for (int index = 0; index < 100; index++) {
            testData.add((int)(Math.random() * 100));
        }

        Chapter16MergeSort mSort = new Chapter16MergeSort();
        System.out.println(mSort.splitMerge(testData));



    }





}
