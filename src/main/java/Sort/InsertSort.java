package Sort;

import java.util.Arrays;

public class InsertSort {
    /*
    for this sort algorithm.we have noticed that
    * ok a input array with numbers unsorted
    * we have reviewed that the insertion sort divide the all numbers with
    * 1 the sorted part
    * 2 the unsorted part
    * so we need to search the position for the new number into the sorted part .
    * we need to assume that the left part is sorted . so how to find the insertion
    * position .
    * 1 we find the position of insertion with the compare
    *   so here is the condition . when  ai <= b <= ai+1
    *   so we can find the position with a reversed order .
    * 2 after we find the position we need to put all the elements after the b
    *   move one step back !use the loop to let the ai = ai-1 back order !
        for loop for the add !
      3 we use  a very bad idea which we use another new array to store the
        sorted array . that is bad because we have to use extra space consumption
      4 we can see a sentry to reduce a lot of the you know if condition check out
        that is really great !
        */
    public void sort(int[] input) {
        for (int i = 2; i < input.length; i++) {
            int key = input[i];
            int insertPosition = 0;
            for (int j = i - 1; j >= 1; j--) {
                if(input[j]<=key){
                    insertPosition = i;
                    break;
                }
                if (input[j - 1] <= key && key <= input[j]) {
                    insertPosition = j;
                    break;
                }
            }
            for (int k = i; k >= insertPosition; k--) {
                input[k] = input[k - 1];
            }
            input[insertPosition] = key;
        }
    }

    public static void main(String[] args) {
        int[] input = {-1, 1, 2, 3, 4, 5, 6};
        InsertSort sort = new InsertSort();
        sort.sort(input);
        System.out.println(Arrays.toString(input));
    }
}
