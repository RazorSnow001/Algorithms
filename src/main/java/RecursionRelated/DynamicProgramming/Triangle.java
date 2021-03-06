package RecursionRelated.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*after the analysis we find we should let the return just on one specific node rather than
 * the layer !
 * so how to write the code  ?
 * */
public class Triangle {
    private List<List<Integer>> triangle;

    public Triangle(List<List<Integer>> triangle) {
        this.triangle = triangle;
    }

    public int minimumTotal(int layer, int index) {
        int currentNode = triangle.get(layer).get(index);
        if (layer == triangle.size() - 1) {
            return currentNode;
        }
        return Math.min(currentNode + minimumTotal(layer + 1, index),
                currentNode + minimumTotal(layer + 1, index + 1));
    }

    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        input.add(Collections.singletonList(2));
        input.add(Arrays.asList(3,1));
        input.add(Arrays.asList(1,5,2));
        input.add(Arrays.asList(0,1,2,3));
        input.add(Arrays.asList(2,1,1,3,1));
        Triangle triangle  = new Triangle(input);
        int result = triangle.minimumTotal(0,0);
        System.out.println(result);
    }

}
