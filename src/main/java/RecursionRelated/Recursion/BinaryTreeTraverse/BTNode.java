package RecursionRelated.Recursion.BinaryTreeTraverse;

public class BTNode {
    int val;
    BTNode leftChild;
    BTNode rightChild;

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
