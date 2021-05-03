package RecursionRelated.Recursion;

/* so we know what is the logic of the quick sort*/
public class QuickSort {
    public void quickSort(int[] input, int begin, int end) {
        if (begin < end) {
            int positionOfPivot = partition(input, begin, end);
            quickSort(input, begin, positionOfPivot - 1);
            quickSort(input, positionOfPivot + 1, end);
        }
    }

    public int partition(int[] input, int begin, int end) {
        int pivot = input[end];
        int i = begin;
        int j = end - 1;
        while (i <= j) {
            if (input[i] <= pivot) {
                i++;
                continue;
            }
            if (input[j] > pivot) {
                j--;
            } else {
                exchangeElement(input, i, j);
            }
        }
        exchangeElement(input, i, end);
        return i;
    }

    private void exchangeElement(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
