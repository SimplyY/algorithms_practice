package com.structure;

/**
 * Created by structure on 2015/1/26.
 */

//单链表默认各节点值都不相等
public class LinkList {
    Node head = null;

    public LinkList(){

    }

    public void setHead(int data){
        head = new Node();
        head.setData(data);
        head.setNext(null);
    }

    public Node search(int data){
        Node theNode = head;
        while (theNode != null){
            if (theNode.getData() == data){
                return theNode;
            }
            else{
                theNode = theNode.getNext();
            }
        }
        System.out.println("未查找到data为" + data + "的node，此方法返回值为空");
        return null;
    }
//向节点后插入
    public void insert(Node prevNode, int data){
        Node newNode = new Node();
        newNode.setData(data);
        newNode.setNext(null);
//注意，先set newNode的next，在set prevNode的next
        if(prevNode.getNext() != null) {
            Node nextNode = prevNode.getNext();
            newNode.setNext(nextNode);
        }

        prevNode.setNext(newNode);
    }

    public void deleteInData(int data){
        Node theNode = head;
        if (head == null){
            return;
        }
        else if(head.getData() == data){
            head = null;
        }
        while (theNode.getNext() != null){
            Node nextNode = theNode.getNext();
            if (nextNode.getData() == data){
                deleteNextNode(theNode);
                break;
            }
            else{
                theNode = theNode.getNext();
            }
        }
        System.out.println("未查找到data为" + data + "的node，此方法返回值为空");
    }

//通过前节点删除后节点
    public void deleteNextNode(Node prevNode){
        if (prevNode.getNext() != null){
            Node theNode =  prevNode.getNext();
            if (theNode.getNext() != null){
                prevNode.setNext(theNode.getNext());
            }
            else{
                prevNode.setNext(null);
            }
        }
    }

    public Node getMinNode() {
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        Node theNode = head;
        Node theMinNode = head;
        while (theNode != null) {
            if (theNode.getData() < theMinNode.getData()) {
                theMinNode = theNode;
            }
            theNode = theNode.getNext();
        }
        return theMinNode;
    }

    public Node getSuccessor(Node theNode){
        if (head == null){
            System.out.println("链表为空");
            return null;
        }
        Node theSuccessor = theNode;
        Node currentNode = head;

//找到一个比theNode更大的Node，作为较大值
        while (currentNode != null){
            if (currentNode.getData() > theSuccessor.getData()){
                theSuccessor = currentNode;
                break;
            }
            currentNode = currentNode.getNext();
        }

//重新开始遍历
        currentNode = head;
        while (currentNode != null){
//找到符合条件的当前节点值(大于查询节点值并且小于之前找到的较大值)，赋为较大值
            if (currentNode.getData() >theNode.getData() && currentNode.getData() < theSuccessor.getData()){
                theSuccessor = currentNode;
            }
            currentNode = currentNode.getNext();
        }

//当没找到successor时
        if (theSuccessor.getData() == theNode.getData()){
            return null;
        }
        return theSuccessor;
    }

    public void output(){
        Node currentNode = head;
        while (currentNode != null){
            System.out.print(currentNode.getData() + " ");
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }

    public void outputSorted(){
        Node MinNode = getMinNode();
        System.out.print(MinNode.getData() + " ");
        Node currentSuccessor = getSuccessor(MinNode);
        while (currentSuccessor != null){
            System.out.print(currentSuccessor.getData() + " ");
            currentSuccessor = getSuccessor(currentSuccessor);
        }
        System.out.println();
    }

}
