package RecursionRelated.DynamicProgramming;

/*this problem actually our beginning of the algorithms study
and that is the overlap problem . ok
now think about it .that is about recursion
and yes that is easy .but the main difficult part is  the set theory
how do you do the set divide the group and so on
3 4 --- 1 3  | 2 2 | 3 1
how to decrease the gate for the recursion
we use the different set
for example
a rod with 10 length
we cut 2   8
the first set is max 2 and max 8 -- max 3 max 7 and so on
but we find the problem --- we eventually max 8 and max 2 that is duplicate computing !
but this set divide is ok ! we use the recursion for abstraction to encapsulate details !
that is ok !
or
the set will be 2 and max8 --- 8 and max2
why this one is more great because that is the data structure usage .
this 2 means one cut and we do get 2 that is definite now ! so that is the DFS
so the DP is just a DFS so that is recursion with compare and with overlap problem.
*  */
public class RodCut {
    public int[] priceTable;

    public RodCut(int[] priceTable) {
        this.priceTable = priceTable;
    }

    public int maxProfit(int length) {
        if (length == 0) {
            return 0;
        }
        int end = Math.min(length, priceTable.length - 1);
        int maxProfit = 0;
        for (int i = 1; i <= end; i++) {
            int currentProfit = priceTable[i] + maxProfit(length - i);
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] priceTable = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        RodCut rodCut = new RodCut(priceTable);
        int length = 20;
        int result = rodCut.maxProfit(length);
        System.out.println(result);
        HowToCut howToCut = new HowToCut(priceTable);
        howToCut.findCutWay(result, length);
        System.out.println(howToCut.recordList);
    }
}
