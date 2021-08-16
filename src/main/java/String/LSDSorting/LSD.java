package String.LSDSorting;


/* that is just the loop usage of the previous key index counting sort
*  we do the sort from the end column to the beginning column to keep the
*  constraints . the left satisfy the order first . that is really great .
*  so we sort the string and the component of the string is the char
*  the number so here we best use a consistent execution of these elements
*  don't to check if it is a char or number . so how to do that ?
*  we see the implementation of this consistency use the 256 array
*  why ?
*  because char is number and number is number too ?
*       char test = '#';
        System.out.println(test+2);
        * but number like 1 is not 1 actually
*  test ?!
*  ok now we know how to implement this programming
*  1 use the outer loop to control we use the key index sort according to which column or which char
*  2 in the loop . every time we sort the elements with the current column char .
*  3 because we do n(n is the length of the element string ) sorts from the bottom to top .
*    so after so many times exchange position .
     so how to exchange the position .
     we can do this operation if we have the array .
     that is hard to do that but !
     * you'd better use a new list or the array to record the order result . and for save space .
     * we do a copy back operation rather than just return the immediate result . that is very great for
     * the outer loop nested with many key index sort . actually we just keep one result array or list
     *  we even don't need to return
     * the method will return void rather than the list !
 */

import java.util.Arrays;

public class LSD {
    public void sortByLSD(String[] inputStringArray, int lengthOfElement) {
        int R = 256;
        for (int i = lengthOfElement - 1; i >= 0; i--) {
            int[] record = new int[R + 1];
            String[] executionArray = new String[inputStringArray.length];
            for (int j = 0; j < inputStringArray.length; j++) {
                record[inputStringArray[j].charAt(i) + 1]++;
            }
            for (int k = 0; k < record.length - 1; k++) {
                record[k + 1] = record[k] + record[k + 1];
            }
            for (String str : inputStringArray) {
                record[str.charAt(i)]++;
                int resultIndex = record[str.charAt(i)];
                executionArray[resultIndex-1] = str;
            }
            for (int j = 0; j < inputStringArray.length; j++) {
                inputStringArray[j] = executionArray[j];
            }
        }
    }

    public static void main(String[] args) {
        String[] input = {"3HFG2D","6KAB1C","1ZKQ5D","3AZB3A","6CBD2A","4CAK3D","2CBA8A"};
        LSD lsd = new LSD();
        lsd.sortByLSD(input,6);
        Arrays.stream(input).forEach(System.out::println);
    }
}
