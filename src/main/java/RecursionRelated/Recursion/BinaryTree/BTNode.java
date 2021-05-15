package RecursionRelated.Recursion.BinaryTree;

public class BTNode {
    public int val;
    public BTNode leftChild;
    public BTNode rightChild;

    public BTNode() {

    }

    public BTNode(int val) {
        this.val = val;
    }

    public BTNode(int val, BTNode leftChild, BTNode rightChild) {
        this.val = val;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

}
