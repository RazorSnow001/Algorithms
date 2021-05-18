package RecursionRelated.DynamicProgramming;

public class DynamicProgramming_RodCut_TopBottom {
    public int[] priceTable;


    public DynamicProgramming_RodCut_TopBottom(int[] priceTable) {
        this.priceTable = priceTable;
    }

    public int recordTheMaxProfit(int length, int[] recordArray) {
        if (length == 0) {
            return 0;
        }
        for (int i = 1; i <= Math.min(length, priceTable.length - 1); i++) {
            int current;
            if (recordArray[length - i] == 0) {
                current = priceTable[i] + recordTheMaxProfit(length - i, recordArray);
            } else {
                current = priceTable[i] + recordArray[length - i];
            }
            recordArray[length] = Math.max(current, recordArray[length]);
        }
        return recordArray[length];
    }

    public static void main(String[] args) {
        int[] priceTable = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        DynamicProgramming_RodCut_TopBottom findMax
                = new DynamicProgramming_RodCut_TopBottom(priceTable);
        int[] record = new int[21];
        int result = findMax.recordTheMaxProfit(20, record);
        System.out.println(result);
    }
}
