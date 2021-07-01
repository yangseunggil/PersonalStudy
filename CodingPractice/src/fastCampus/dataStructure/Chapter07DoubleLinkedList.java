package fastCampus.dataStructure;

import fastCampus.dataStructure.util.DoubleNode;
import fastCampus.dataStructure.util.SingleNode;

// Double Linked List
// 연결 포인트가 앞과 뒤가 있는 구조
public class Chapter07DoubleLinkedList<T> {

    public DoubleNode<T> head = null;
    public DoubleNode<T> tail = null;

    public void addNode(T data){
        if(this.head == null){
            this.head = new DoubleNode<T>(data);
            this.tail = this.head;
        }else{
            DoubleNode<T> node = this.head;
            while (node.next != null){
                node = node.next;
            }
            node.next = new DoubleNode<T>(data);
            node.next.prev = node;
            this.tail = node.next;
        }
    }

    public void printAll(){
        if(this.head != null){
            DoubleNode<T> node = this.head;
            System.out.println(node.data);
            while (node.next != null){
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    public DoubleNode<T> searchFromHead(T data){
        DoubleNode<T> node = this.head;
        // while (node.next != null){ 반복문 조건 틀림
        while (node != null){
            if(node.data == data){
                return node;
            }else{
                node = node.next;
            }
        }
        return null;
    }

    public DoubleNode<T> searchFromTail(T data){
        DoubleNode<T> node = this.tail;
        // while (node.prev == this.head){ 반복문 조건 틀림
        while (node != null){
            if(node.data == data){
                return node;
            }else{
                node = node.prev;
            }
        }
        return null;
    }

    public boolean insertToFront(T backData, T newData){
        DoubleNode<T> backNode = this.searchFromHead(backData);
        DoubleNode<T> newNode = new DoubleNode<T>(newData);
        if(backNode != null){
            if(backNode == this.head){
                this.head = newNode;
                newNode.next = backNode;
                backNode.prev = newNode;
            }else{
                DoubleNode<T> frontNode = backNode.prev;
                frontNode.next = newNode;
                newNode.prev = frontNode;
                newNode.next = backNode;
                backNode.prev = newNode;
            }
            return true;
        }
        return false;
    }




    public static void main (String [] args){


        Chapter07DoubleLinkedList<Integer> MyLinkedList = new Chapter07DoubleLinkedList<Integer>();

        MyLinkedList.addNode(1);
        MyLinkedList.addNode(2);
        MyLinkedList.addNode(3);
        MyLinkedList.addNode(4);
        MyLinkedList.addNode(5);

        MyLinkedList.printAll();
        System.out.println("----------------------------------------------------------");
        MyLinkedList.insertToFront(3, 2);
        MyLinkedList.printAll();

        System.out.println("----------------------------------------------------------");

        MyLinkedList.insertToFront(6, 2);
        MyLinkedList.insertToFront(1, 0);
        MyLinkedList.printAll();
        System.out.println("----------------------------------------------------------");

        MyLinkedList.addNode(6);
        MyLinkedList.insertToFront(6,7);
        MyLinkedList.printAll();

    }
}
