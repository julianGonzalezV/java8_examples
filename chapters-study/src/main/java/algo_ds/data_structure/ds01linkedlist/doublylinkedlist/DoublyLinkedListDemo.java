package algo_ds.data_structure.ds01linkedlist.doublylinkedlist;

public class DoublyLinkedListDemo {

    private static DoublyLinkedList getDoublyLinkedList(){
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.insertAtHead(5);
        linkedList.insertAtHead(4);
        return linkedList;
    }

    public static void main(String[] args) {
        DoublyLinkedList linkedList = getDoublyLinkedList();
        System.out.println(linkedList);
    }
}
