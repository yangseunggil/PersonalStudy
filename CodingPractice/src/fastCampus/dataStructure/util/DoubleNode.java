package fastCampus.dataStructure.util;

public class DoubleNode<T> {
    public T data;
    public DoubleNode<T> prev = null;
    public DoubleNode<T> next = null;

    public DoubleNode(T data){
        this.data = data;
    }

}
