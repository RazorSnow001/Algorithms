package Search;

import java.util.Arrays;

public class BinarySearch implements Search {
    int[] input;
    int key;
    int beginIndex;
    int endIndex;

    public BinarySearch(int[] input, int key) {
        this.input = input;
        this.key = key;
        this.beginIndex = 0;
        this.endIndex = input.length - 1;
    }

    @Override
    public int search() {
        int resultIndex = -1;
        Arrays.sort(input);
        System.out.println();
        System.out.println(Arrays.toString(input));
        int middle = (endIndex - beginIndex) / 2 + beginIndex;
        while (beginIndex < endIndex) {
            if (input[middle] == key) {
                resultIndex = middle;
                break;
            }
            if (input[middle] > key) {
                endIndex = endIndex - 1;
            } else {
                beginIndex = beginIndex + 1;
            }
            middle = (endIndex - beginIndex) / 2 + beginIndex;
        }
        return resultIndex;
    }
}
