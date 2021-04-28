import Util.ArrayCreation;
import org.testng.annotations.Test;

public class TestArrays {
    @Test
    public void test01TwoDimensionalArray() {
        ArrayCreation creation = new ArrayCreation();
        int[][] result = creation.createTwoDimensionalArrayWith01(5, 6);
    }


}
