package algo_ds.data_structure.ds01linkedlist;

/**
 * See notes here:
 * https://docs.google.com/document/d/12xcmrFiZXYlXmJ5Xzp7tPzFjPiQenn0CUiPYfDVtQC8/edit
 */
public class Node {


    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }

    private int data;
    private Node nextNode;

    public int getData(){
        return this.data;
    }

    public Node getNextNode(){
        return this.nextNode;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return "Data: "+ this.data;
    }
}
