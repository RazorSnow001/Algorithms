package RecursionRelated.Recursion.BinaryTreeTraverse;

public class BTNodeTraverse {
    public void PreOrder(BTNode node) {
        if (node != null) {
            System.out.println(node.val);
            PreOrder(node.leftChild);
            PreOrder(node.rightChild);
        }
    }

    public void InOrder(BTNode node) {
        if (node != null) {
            PreOrder(node.leftChild);
            System.out.println(node.val);
            PreOrder(node.rightChild);
        }
    }

    public void PostOrder(BTNode node) {
        if (node != null) {
            PreOrder(node.leftChild);
            PreOrder(node.rightChild);
            System.out.println(node.val);
        }
    }

}
