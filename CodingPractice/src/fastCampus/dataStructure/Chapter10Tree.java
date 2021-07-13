package fastCampus.dataStructure;


import fastCampus.dataStructure.util.BinaryNode;

public class Chapter10Tree {

    BinaryNode head;

    public boolean insertNode(int value){
        BinaryNode currentNode = this.head;
        if(currentNode == null){
            this.head = new BinaryNode(value);
        }else{
            while (true){
                if(currentNode.value > value){
                    if(currentNode.left == null){
                        currentNode.left = new BinaryNode(value);
                        break;
                    }else{
                        currentNode = currentNode.left;
                    }
                }else{
                    if(currentNode.right == null){
                        currentNode.right = new BinaryNode(value);
                        break;
                    }else{
                        currentNode = currentNode.right;
                    }
                }
            }
        }
        return true;
    }


    public boolean deleteNode(int value){
        boolean isSearched = false;

        BinaryNode parent = this.head;
        BinaryNode current = this.head;

        // Root에 아무런 데이터가 없을 때
        if(this.head == null ){
            return false;
        }
        // Root만 존재할 때
        else if(this.head != null &&
                this.head.left == null &&
                this.head.right == null){
            this.head = null;
            return true;
        }

        // 삭제할 노드 탐색
        while (current != null){
            if(current.value == value){
                isSearched = true;
                break;
            }else{
                if(current.value < value){
                    parent = current;
                    current = current.right;
                }else{
                    parent = current;
                    current = current.left;
                }
            }
        }

        // 탐색해도 못찾으면 삭제 실패
        if(!isSearched){
            return false;
        }

        // Case 1. 탐색된 노드가 최하단(Leaf Node) 혹은 자식노드가 없을 때
        if(current != null &&
           current.left == null &&
           current.right == null){
            if(parent.value < value){
                parent.right = null;
                current = null;
            }else{
                parent.left = null;
                current = null;
            }
        }
        // Case 2. 탐색된 노드의 자식노드가 하나만 있을 때
        // 왼쪽 자식 노드만 있을 때
        else if(current.left != null &&
                current.right == null){
            // 탐색된 노드가 부모의 오른쪽 자식일 때
            if(parent.value < value){
                parent.right = current.left;
                current = null;
            }
            // 탐색된 노드가 부모의 왼쪽 자식일 때
            else{
                parent.left = current.left;
                current = null;
            }
        }
        // 오른쪽 자식 노드만 있을 때
        else if(current.left == null &&
                current.right != null){
            // 탐색된 노드가 부모의 오른쪽 자식일 때
            if(parent.value < value){
                parent.right = current.right;
                current = null;
            }
            // 탐색된 노드가 부모의 왼쪽 자식일 때
            else{
                parent.left = current.right;
                current = null;
            }
        }

        // Case 3. 탐색된 노드의 자식노드가 두 개 있을 때
        else{

            BinaryNode changeNodeParent = current.right;
            BinaryNode changeNode = current.right;;

            while(changeNode.left != null){
                changeNodeParent = changeNode;
                changeNode = changeNode.left;
            }

            // ChangeNode의 오른쪽 자식이 있을 때
            if(changeNode.right != null){
                changeNodeParent.left = changeNode.right;
            }else{
                changeNodeParent.left = null;
            }

            // 탐색된 노드가 부모의 왼쪽일 때
            if(parent.value > value){
                parent.left = changeNode;
            }
            // 탐색된 노드가 부모의 왼쪽일 때
            else{
                parent.right = changeNode;
            }

            changeNode.left = current.left;
            changeNode.right = current.right;
            current = null;
        }
        return true;
    }






    public static void main (String [] args){

        Chapter10Tree myTree = new Chapter10Tree();
        myTree.insertNode(10);
        myTree.insertNode(15);
        myTree.insertNode(13);
        myTree.insertNode(11);
        myTree.insertNode(14);
        myTree.insertNode(18);
        myTree.insertNode(16);
        myTree.insertNode(19);
        myTree.insertNode(17);
        myTree.insertNode(7);
        myTree.insertNode(8);
        myTree.insertNode(6);
        System.out.println(myTree.deleteNode(15));
        System.out.println("HEAD: " + myTree.head.value);
        System.out.println("HEAD LEFT: " + myTree.head.left.value);
        System.out.println("HEAD LEFT LEFT: " + myTree.head.left.left.value);
        System.out.println("HEAD LEFT RIGHT: " + myTree.head.left.right.value);

        System.out.println("HEAD RIGHT: " + myTree.head.right.value);
        System.out.println("HEAD RIGHT LEFT: " + myTree.head.right.left.value);
        System.out.println("HEAD RIGHT RIGHT: " + myTree.head.right.right.value);

        System.out.println("HEAD RIGHT RIGHT LEFT: " + myTree.head.right.right.left.value);
        System.out.println("HEAD RIGHT RIGHT RIGHT: " + myTree.head.right.right.right.value);
    }

}
