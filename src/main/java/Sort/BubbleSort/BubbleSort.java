package Sort.BubbleSort;

import java.util.Arrays;

public class BubbleSort {
    public void sort(int[] input){
        for (int i=1;i<=input.length-1;i++){
            for(int k=0;k<=input.length-1-i;k++){
                if(input[k]>input[k+1]){
                    int temp = input[k];
                    input[k] = input[k+1];
                    input[k+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] input = {1,5,6,2,4,3,8,10};
        BubbleSort sort = new BubbleSort();
        sort.sort(input);
        System.out.println(Arrays.toString(input));
    }
}
