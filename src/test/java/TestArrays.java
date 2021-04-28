import Util.ArrayCreation;
import org.testng.annotations.Test;

public class TestArrays {
    @Test
    public void test01TwoDimensionalArray() {
        ArrayCreation creation = new ArrayCreation();
        int[][] result = creation.createTwoDimensionalArrayWith01(5, 6);
        display01TwoDimensionalArray(result);
    }

    private void display01TwoDimensionalArray(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%3d", ints[j]);
            }
            System.out.println();
        }
    }
}
