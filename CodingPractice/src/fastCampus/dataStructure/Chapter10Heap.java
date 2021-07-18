package fastCampus.dataStructure;

import java.util.*;

public class Chapter10Heap {

    public List<Integer> heap;

    public Chapter10Heap(int value){
        heap = new ArrayList<Integer>();
        heap.add(null);
        heap.add(value);
    }

    public boolean insert(int value){
        if(this.heap == null){
            heap = new ArrayList<Integer>();
            heap.add(null);
            heap.add(value);
            return true;
        }

        heap.add(value);
        Integer insertedIdx = heap.size() - 1;
        while (moveUp(insertedIdx)){
            Integer parentIdx = insertedIdx / 2;
            Collections.swap(this.heap , insertedIdx, parentIdx);
            insertedIdx = parentIdx;
        }
        return true;
    }

    public boolean moveUp(int insertedIdx){
        if(insertedIdx <= 1){
            return false;
        }
        int parentIdx = insertedIdx / 2;
        if(this.heap.get(insertedIdx) > this.heap.get(parentIdx)){
            return true;
        }
        return false;
    }

    public boolean moveDown(Integer parentIdx){
        Integer leftIdx = parentIdx * 2;
        Integer rightIdx = parentIdx * 2 + 1;

        // 자식노드가 없을 때(왼쪽 노드가 없을때만 판단 하면 된다.)
        // if(this.heap.get(leftIdx) == null  ){
        if (leftIdx >= this.heap.size()) {
            return false;
        }

        // 왼쪽 노드만 있을 때
        // else if( this.heap.get(rightIdx) == null ){
        else if (rightIdx >= this.heap.size()) {
            // 자식 값이 크면 스왑 조건 성립
            if(this.heap.get(parentIdx) <= this.heap.get(leftIdx)){
                return true;
            }else{
                return false;
            }
        }

        // 양쪽 모두 있을 때
        else{
            // 왼쪽이 클 때
            if(this.heap.get(leftIdx) >= this.heap.get(rightIdx)){
                // 자식 값이 크면 스왑 조건 성립
                if(this.heap.get(parentIdx) <= this.heap.get(leftIdx)){
                    return true;
                }else{
                    return false;
                }
            }
            // 오른쪽이 클 때
            else if(this.heap.get(leftIdx) <= this.heap.get(rightIdx)){
                // 자식 값이 크면 스왑 조건 성립
                if(this.heap.get(parentIdx) <= this.heap.get(rightIdx)){
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }




    public Integer pop(){
        if(this.heap == null){
            return null;
        }

        Integer parentIdx = 1;
        Integer returnValue = this.heap.get(1);
        this.heap.set(1, this.heap.get(this.heap.size()-1));
        this.heap.remove(this.heap.size()-1);

        while (moveDown(parentIdx)){
            Integer leftIdx = parentIdx * 2;
            Integer rightIdx = parentIdx * 2 + 1;

            // 왼쪽 노드만 있을 때
            if( this.heap.get(rightIdx) == null ){
                // 자식 값이 크면 스왑 조건 성립(이 조건은 없어도 되나 명시화를 위해 작성함)
                if(this.heap.get(parentIdx) <= this.heap.get(leftIdx)){
                    Collections.swap(this.heap, leftIdx, parentIdx);
                    parentIdx = leftIdx;
                }
            }

            // 양쪽 모두 있을 때
            else{
                // 왼쪽이 클 때
                if(this.heap.get(leftIdx) >= this.heap.get(rightIdx)){
                    if(this.heap.get(parentIdx) <= this.heap.get(rightIdx)){
                        Collections.swap(this.heap, rightIdx, parentIdx);
                        parentIdx = rightIdx;
                    }
                }
                // 오른쪽이 클 때
                else if(this.heap.get(leftIdx) <= this.heap.get(rightIdx)){
                    if(this.heap.get(parentIdx) <= this.heap.get(rightIdx)){
                        Collections.swap(this.heap, rightIdx, parentIdx);
                        parentIdx = rightIdx;
                    }
                }
            }
        }
        return returnValue;
    }




    public static void main(String args[]){
        Chapter10Heap heapTest = new Chapter10Heap(15);
        heapTest.insert(10);
        heapTest.insert(8);
        heapTest.insert(5);
        heapTest.insert(4);
        heapTest.insert(20);
        System.out.println(heapTest.heap);

        heapTest.pop();
        System.out.println(heapTest.heap);
    }



}
