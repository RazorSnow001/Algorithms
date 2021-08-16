package String.MSDSorting;

import java.util.Arrays;
public class MSD {
    public void sortByMSD(String[] input, int begin, int end, int position) {
        if (begin == end) {
            return;
        }

        int[] record = new int[257];
        String[] execution = new String[end - begin + 1];
        for (int i = begin; i <= end; i++) {
            record[input[i].charAt(position) + 1]++;
        }
        for (int i = 0; i < record.length - 1; i++) {
            record[i + 1] = record[i] + record[i + 1];
        }
        for (int i = begin; i <= end; i++) {
            record[input[i].charAt(position)]++;
            int index = record[input[i].charAt(position)];
            execution[index - 1] = input[i];
        }
        if (end + 1 - begin >= 0) System.arraycopy(execution, begin, input, begin, end + 1 - begin);
        int[] group = Arrays.stream(record).filter(i -> i > 0).toArray();
        for (int i = 0; i < group.length; i++) {
            if (i == 0) {
                begin = 0;
            } else {
                begin = group[i - 1] + 1;
            }
            end = group[i] - 1;
            sortByMSD(input, begin, end, position + 1);
        }
    }

    public static void main(String[] args) {
        String[] input = {"3HFG2D","6KAB1C","1ZKQ5D","3AZB3A","6CBD2A","4CAK3D","2CBA8A"};
        MSD msd = new MSD();
        msd.sortByMSD(input,0,6,0);
        Arrays.stream(input).forEach(System.out::println);
    }

}
