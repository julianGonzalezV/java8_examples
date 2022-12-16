package algo_ds.data_structure.ds01linkedlist;

public class DoublyEndedList {
    private Node head;
    private Node tail;


    public void insertAtTail(int data){
        Node newNode = new Node(data);
        if(this.head == null){
            this.head = newNode;
        }
        if(this.tail != null){
            this.tail.setNextNode(newNode);
        }
        this.tail = newNode;
    }


    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }


    @Override
    public String toString() {
        String result = "{";
        Node current = this.head;
        while (current != null){
            result += current +",";
            current = current.getNextNode();
        }
        result += "}";
        return result;
    }
}
