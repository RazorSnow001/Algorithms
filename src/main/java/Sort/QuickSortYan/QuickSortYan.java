package Sort.QuickSortYan;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Arrays;

@Data
@Accessors(chain = true)
public class QuickSortYan {
    private int[] input;

    public QuickSortYan(int[] input) {
        this.input = input;
    }

    public void sort(int low, int high) {
        if (low < high) {
            int cutPoint = execute(low, high);
            sort(low, cutPoint - 1);
            sort(cutPoint + 1, high);
        }
    }

    private int execute(int low, int high) {
        int povit = input[low];
        while (low < high) {
            while (low < high && input[high] >= povit) high--;
            input[low] = input[high];
            while (low < high && input[low] < povit) low++;
            input[high] = input[low];
        }
        input[low] = povit;
        return low;
    }

    public static void main(String[] args) {
        int[] input = {6, 3, 8, 2, 9, 1, 5, 8, 7, 0};
        QuickSortYan quickSortYan = new QuickSortYan(input);
        quickSortYan.sort(0, input.length - 1);
        Arrays.stream(input).forEach(System.out::println);
    }

}
