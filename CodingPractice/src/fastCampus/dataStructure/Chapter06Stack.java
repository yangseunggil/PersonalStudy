package fastCampus.dataStructure;

import java.util.ArrayList;

public class Chapter06Stack<T> {

    // 내가 만듬, 교재 내용 동일
    private ArrayList<T> stack = new ArrayList<T>();

    public T pop(){
        if(stack.isEmpty()){
            return null;
        }
        return stack.remove(stack.size()-1);
    }

    public void push(T item){
        stack.add(item);
    }

    





}
