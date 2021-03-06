package Tree;

import java.util.Objects;

public class TraverseTree {
    public class TreeNode {

        private int value;
        private TreeNode left;
        private TreeNode right;
    }

    /*εεΊιε*/
    public void printTree(TreeNode tree) {
        if (Objects.nonNull(tree)) {
            System.out.println(tree.value);
            printTree(tree.left);
            printTree(tree.right);
        }
    }

}
