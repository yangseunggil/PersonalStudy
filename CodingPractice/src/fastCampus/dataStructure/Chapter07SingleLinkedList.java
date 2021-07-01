package fastCampus.dataStructure;

import fastCampus.dataStructure.util.DoubleNode;
import fastCampus.dataStructure.util.SingleNode;

// Single Linked List
// 연결 포인트가 뒤만 가리키는 구조
public class Chapter07SingleLinkedList<T> {

    SingleNode<T> head;

    public void addData(T data){
        if(head == null){
            head = new SingleNode<T>(data);
        }else{
            SingleNode<T> node = head;
            while (node.next != null){
                node = node.next;
            }
            node.next = new SingleNode<T>(data);
        }
    }

    public void addData(T data, T prevData){
        // search
        SingleNode<T> current = this.head;
        while(current != null){
            if(current.data == prevData){
                break;
            }else{
                current = current.next;
            }
        }

        // add
        if(current == null){
            // 이렇게 하면 안되고 걍 맨 뒤에 넣어야지
            // head = new Node<T>(data);
            this.addData(prevData);
        }else{
            SingleNode<T> newData = new SingleNode<T>(data);
            SingleNode<T> postData = current.next;
            current.next = newData;
            newData.next = postData;
        }
    }

    public boolean remove(T data){
        SingleNode<T> current = this.head;
        SingleNode<T> prev = this.head;
        if(current == null){
            return false;
        }

        // 헤드 삭제
        if(current.data == data){
            this.head = current.next;
            return true;
        }else{
            while (current != null){
                if(current.data != data){
                    prev = current;
                    current = current.next;
                }else{
                    prev.next = current.next;
                    return true;
                }
            }

            // 답안
            /*
            while (current.next != null) {
                if (current.next.data == data) {
                    current.next = current.next.next;
                    return true;
                }
                current = current.next;
            }
            */

        }
        // tail
        // 굳이 할 필요 없네
        // current.next = null;

        // 반복문 다 끝나도 못찾았으면 false를 반환해야지
        // return true;
        return false;
    }



    public void printAll(){
        if(head != null){
            SingleNode<T> node = head;
            System.out.println(node.data);
            while (node.next != null){
                node = node.next;
                System.out.println(node.data);
            }
        }

    }

    public static void main (String [] args){
        Chapter07SingleLinkedList<Integer> test = new Chapter07SingleLinkedList<Integer>();
        test.addData(1);
        test.addData(2);
        test.addData(3);
        test.addData(4);
        test.addData(5);
        test.addData(6);
        test.remove(8);
        test.printAll();


    }

}
