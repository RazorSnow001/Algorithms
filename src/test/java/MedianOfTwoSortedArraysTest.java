import Search.MedianOfTwoSortedArrays;
import Util.ArrayCreation;
import org.testng.annotations.Test;

import java.util.Arrays;

public class MedianOfTwoSortedArraysTest {
     @Test
     public  void test(){
         MedianOfTwoSortedArrays find = new MedianOfTwoSortedArrays();
         ArrayCreation creation = new ArrayCreation();
         int[] input = creation.create(3, 20);
         ArrayCreation creation2 = new ArrayCreation();
         int[] input2 = creation2.create(4, 20);
         Arrays.sort(input);
         Arrays.sort(input2);
         creation.displayArray(input);
         System.out.println();
         creation.displayArray(input2);
         System.out.println();
         int[] combine = new int[input.length+input2.length];
         for (int i = 0; i < combine.length; i++) {
             combine[i] = (i<input.length)? input[i] : input2[i-input.length];
         }
         Arrays.sort(combine);
         creation.displayArray(combine);
         System.out.println();
         System.out.println(find.findMedian(input,input2));
     }

}