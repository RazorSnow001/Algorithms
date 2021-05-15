package RecursionRelated.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class HowToCut {
    public ArrayList<ArrayList<Integer>> recordList;
    public int[] priceTable;
    public List<Integer> onePath;

    public HowToCut(int[] priceTable) {
        this.recordList = new ArrayList<>();
        this.priceTable = priceTable;
        this.onePath = new ArrayList<>();
    }

    public void findCutWay(int profit, int length) {
        if (length == 0 && profit != 0) {
            return;
        }
        if (length == 0) {
            recordList.add(new ArrayList<>(onePath));
        }
        for (int i = 1; i <= Math.min(priceTable.length - 1, length); i++) {
            onePath.add(i);
            findCutWay(profit - priceTable[i], length - i);
            onePath.remove(onePath.size() - 1);
        }
    }

}
