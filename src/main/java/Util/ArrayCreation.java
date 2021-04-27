package Util;

import java.util.Random;

public class ArrayCreation {
    public ArrayCreation() {

    }
    public int[] create(int length){
        Random random = new Random();
        int[] array = new int[length];
        for (int i = 0; i <length ; i++) {
            array[i] = random.nextInt(10);
        }
        return array;
    }
}
