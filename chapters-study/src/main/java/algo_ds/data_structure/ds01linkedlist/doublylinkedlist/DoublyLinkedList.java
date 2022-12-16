package algo_ds.data_structure.ds01linkedlist.doublylinkedlist;


import algo_ds.data_structure.ds01linkedlist.Node;

public class DoublyLinkedList {
    private DoublyLinkedNode head;


    public void insertAtHeadV1(int data){

        DoublyLinkedNode newNode = new DoublyLinkedNode(data);

        if(this.head == null){
            newNode.setNextNode(null);
            newNode.setPrevNode(null);
            this.head = newNode;
        }
    }

    public void insertAtHead(int data){
        DoublyLinkedNode newNode = new DoublyLinkedNode(data);
        newNode.setNextNode(this.head);
        if(this.head != null){
            this.head.setPrevNode(newNode);
        }

        this.head = newNode;
    }


    public DoublyLinkedNode getHead() {
        return head;
    }

    public void setHead(DoublyLinkedNode head) {
        this.head = head;
    }

    @Override
    public String toString() {
        String result = "{";
        DoublyLinkedNode current = this.head;
        while (current != null){
            result += current +",";
            current = current.getNextNode();
        }
        result += "}";
        return result;
    }



}
