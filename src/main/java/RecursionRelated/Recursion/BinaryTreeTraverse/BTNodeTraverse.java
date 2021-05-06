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
            InOrder(node.leftChild);
            System.out.println(node.val);
            InOrder(node.rightChild);
        }
    }

    public void PostOrder(BTNode node) {
        if (node != null) {
            PostOrder(node.leftChild);
            PostOrder(node.rightChild);
            System.out.println(node.val);
        }
    }

}
