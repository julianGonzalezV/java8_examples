package algo_ds.data_structure.ds01linkedlist;

public class LinkedListDemo {
    private static LinkedList getPopulate(){
        LinkedList linkedList = new LinkedList();
        //10,2,8,6,7,9,3,4,1,0,5
        linkedList.insertAtHead(10);
        linkedList.insertAtHead(2);
        linkedList.insertAtHead(8);
        linkedList.insertAtHead(6);
        linkedList.insertAtHead(7);
        linkedList.insertAtHead(9);
        linkedList.insertAtHead(3);
        linkedList.insertAtHead(4);
        linkedList.insertAtHead(1);
        linkedList.insertAtHead(0);
        linkedList.insertAtHead(5);
        return  linkedList;
    }

    private static LinkedList getOrderedLinkedList(){
        LinkedList linkedList = new LinkedList();
        linkedList.insertAtHead(8);
        linkedList.insertAtHead(2);
        linkedList.insertAtHead(1);

        return  linkedList;
    }


    public static void main(String[] args) {
        LinkedList linkedList = getPopulate();
        DoublyEndedList  doublyEndedList = new DoublyEndedList();

        System.out.println(linkedList);
        System.out.println(linkedList.lenght());
        System.out.println(linkedList);
        /*linkedList.deleteHead();*/
        linkedList.deleteHead();
        linkedList.deleteHead();
        System.out.println(linkedList.lenght());
        System.out.println(linkedList);
        linkedList.insertAtHead(1);
        System.out.println(linkedList.lenght());
        System.out.println("Found: "+linkedList.find(10));
        System.out.println("Found: "+linkedList.find(20));
        System.out.println(":::::::::::::::DOUBLY ENDED LINKED LIST ::::::");
        doublyEndedList.insertAtTail(5);
        doublyEndedList.insertAtTail(6);
        doublyEndedList.insertAtTail(7);
        System.out.println(doublyEndedList);

        System.out.println("IInserted on a ordered likedList");
        LinkedList linkedList2 = getOrderedLinkedList();
        System.out.println(linkedList2);
        linkedList2.insert(6);
        System.out.println(linkedList2);

    }
}
