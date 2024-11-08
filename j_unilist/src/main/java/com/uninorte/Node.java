package com.uninorte;

public class Node {
    private int index;
    private Object data;
    private Node nextNode;
    private Node prevNode;

    public Node(Object data){
        this.data = data;
        index = 0;
    }    

    public Node(int index, Object data){
        this.index = index;
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }    

    public int getIndex() {
        return index;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public Node getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(Node node){
        this.prevNode = node;
    }

    public void setNextNode(Node node){
        this.nextNode = node;
    }
}
