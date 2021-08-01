package Tree;

import java.util.Objects;

public class TraverseTree {
    public class TreeNode {

        private int value;
        private TreeNode left;
        private TreeNode right;
    }

    /*前序遍历*/
    public void printTree(TreeNode tree) {
        if (Objects.nonNull(tree)) {
            System.out.println(tree.value);
            printTree(tree.left);
            printTree(tree.right);
        }
    }

}
