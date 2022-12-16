package algo_ds.data_structure.ds01linkedlist;

/**
 * https://docs.google.com/document/d/12xcmrFiZXYlXmJ5Xzp7tPzFjPiQenn0CUiPYfDVtQC8/edit
 *
 * It is an ORDERED set of data elements where each element contains a link to its successor (n+1 element)
 */
public class LinkedList {
    private Node head;

    /**
     * Constant time
     * @param data
     */
    public void insertAtHead(int data){
        this.head = new Node(data, head);
    }

    /**
     * Constant time
     */
    public void deleteHead(){
        this.head = this.head.getNextNode();
    }

    /**
     * O(n)
     * @return
     */
    public int lenght(){
        int result = 0;
        Node current = this.head;
        while (current != null){
            current = current.getNextNode();
            result++;
        }
        return result;
    }

    /**
     * O(n)
     * @param item
     * @return
     */
    public Node find(int item){
        Node current = this.head;
        while (current!=null){
            if(current.getData() == item) return current;
            current = current.getNextNode();
        }
        return null;
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

    /**
     * This method is gonan insert a node in an already <<ordered>> linkedList
     * @param newNode
     */
    public void insert(int data){
        Node newNode = new Node(data);

        if(this.head == null){
            this.head = newNode;
            return;
        }
        Node current = this.head;

       while(current !=null ){
            if(current.getNextNode() == null || current.getNextNode().getData() > newNode.getData()){
                newNode.setNextNode(current.getNextNode());
                current.setNextNode(newNode);
                break;
            }

            current = current.getNextNode();
        }
    }
}
