package algo_ds.data_structure.trees.binary;

public class TreeNode<T> {
    private T data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(T data) {
        this.data = data;
    }

    public TreeNode(T data, TreeNode leftChild, TreeNode rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public T getData() {
        return data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
}
