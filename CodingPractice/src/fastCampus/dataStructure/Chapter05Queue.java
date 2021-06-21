package fastCampus.dataStructure;

import java.util.ArrayList;
import java.util.List;

public class Chapter05Queue<T> {

    // 내가 작성
    private List<T> queue;
    public void enqueue(T object){
        queue.add(object);
    }

    // LIFO 스택이잖아
    public T dequeue(){
        T returnValue = null;
        if(!queue.isEmpty()){
            int lastIndex = queue.size()-1;
            returnValue = queue.get(lastIndex);
            queue.remove(lastIndex);
        }
        return returnValue;
    }

    // 교재 내용
    private ArrayList<T> qq = new ArrayList<T>();
    public void qqenqueue(T item) {
        qq.add(item);
    }
    public T qqdequeue() {
        if (qq.isEmpty()) {
            return null;
        }
        return qq.remove(0);
    }
    public boolean isEmpty() {
        return qq.isEmpty();
    }


}
