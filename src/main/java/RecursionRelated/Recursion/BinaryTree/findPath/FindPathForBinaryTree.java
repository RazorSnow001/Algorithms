package RecursionRelated.Recursion.BinaryTree.findPath;

import RecursionRelated.Recursion.BinaryTree.BTNode;

import java.util.ArrayList;
import java.util.List;

/*that is actually DFS and we need to find a specific path
 * that is very useful in a lot of the problems such as DP and
 * a lot of recursion */
public class FindPathForBinaryTree {
    public List<List<Integer>> recordList;

    public FindPathForBinaryTree() {
        this.recordList = new ArrayList();
    }

    public void findPath(BTNode root, int target, List<Integer> onePath
    ) {
        if (root == null) {
            return;
        }
        onePath.add(root.val);
        if (root.val == target) {
            List<Integer> copy = new ArrayList<>(onePath);
            recordList.add(copy);
        }
        findPath(root.leftChild, target, onePath);
        findPath(root.rightChild, target, onePath);
        onePath.remove(onePath.size() - 1);
    }


    public static void main(String[] args) {
        BTNode root = new BTNode(1);
        BTNode oneLeft = new BTNode(7);
        BTNode oneRight = new BTNode(8);
        BTNode twoLeft = new BTNode(6);
        BTNode twoRight = new BTNode(6);
        root.leftChild = oneLeft;
        root.rightChild = oneRight;
        oneRight.leftChild = twoLeft;
        oneLeft.rightChild = twoRight;
        FindPathForBinaryTree findPathForBinaryTree = new FindPathForBinaryTree();
        List<Integer> onePath = new ArrayList<>();
        findPathForBinaryTree.findPath(root, 6, onePath);
        System.out.println(findPathForBinaryTree.recordList);
    }
}
