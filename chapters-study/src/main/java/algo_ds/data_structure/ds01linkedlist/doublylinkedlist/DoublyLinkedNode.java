package algo_ds.data_structure.ds01linkedlist.doublylinkedlist;

import algo_ds.data_structure.ds01linkedlist.Node;

public class DoublyLinkedNode {
    private DoublyLinkedNode nextNode;
    private DoublyLinkedNode prevNode;
    private int data;

    public DoublyLinkedNode(int data) {
        this.data = data;
    }

    public DoublyLinkedNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(DoublyLinkedNode nextNode) {
        this.nextNode = nextNode;
    }

    public DoublyLinkedNode getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(DoublyLinkedNode prevNode) {
        this.prevNode = prevNode;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "Data: "+ this.data;
    }
}
