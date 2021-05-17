package RecursionRelated.DynamicProgramming;

/* ok now we do the transform work ok
 * now we have the recursion version of th rod cut problem that is really great
 * merge the duplicate nodes into one nodes that is really great !
 * so bottom to top
 *
 * */
public class DynamicProgramming_RodCut {
    public int[] priceTable;

    public DynamicProgramming_RodCut(int[] priceTable) {
        this.priceTable = priceTable;
    }

    public int getMaxProfit(int length) {
        int[] recordArray = new int[length + 1];
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= Math.min(i, priceTable.length - 1); j++) {
                int currentProfit = priceTable[j] + recordArray[i - j];
                recordArray[i] = Math.max(currentProfit, recordArray[i]);
            }
        }
        return recordArray[length];
    }

    public static void main(String[] args) {
        int[] priceTable = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        DynamicProgramming_RodCut dynamicProgramming_rodCut
                = new DynamicProgramming_RodCut(priceTable);
        int maxProfit = dynamicProgramming_rodCut.getMaxProfit(20);
        System.out.println(maxProfit);
        HowToCut howToCut = new HowToCut(priceTable);
        howToCut.findCutWay(maxProfit, 20);
        System.out.println(howToCut.recordList);
    }
}
