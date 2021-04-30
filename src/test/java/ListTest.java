import Leetcode.List.AddTwoNumbers;
import Leetcode.List.ListNode;
import Util.ArrayCreation;
import Util.ListCreateWithReverseOrder;
import org.testng.annotations.Test;

public class ListTest {
    @Test
    public void testList() {
        ArrayCreation createArray = new ArrayCreation();
        int[] input = createArray.create(10);
        ListCreateWithReverseOrder createList = new ListCreateWithReverseOrder(input);
        createList.reverseCreate();
        System.out.println("test new theme");
        System.out.println("test pull project");
    }

    @Test
    public void testListSum() {
        ArrayCreation createArray = new ArrayCreation();
        int[] input1 = createArray.create(3);
        int[] input2 = createArray.create(5);
        ListCreateWithReverseOrder createList = new ListCreateWithReverseOrder(input1);
        createList.reverseCreate();
        ListNode list1 = createList.list;
        ListCreateWithReverseOrder createList2 = new ListCreateWithReverseOrder(input2);
        createList2.reverseCreate();
        ListNode list2 = createList2.list;
        AddTwoNumbers add = new AddTwoNumbers();
        ListNode list3 = add.addTwoNumbers(list1, list2);
        displayList(list3);
    }

    private void displayList(ListNode list) {
        while (list != null) {
            System.out.printf("%3d", list.val);
            list = list.next;
        }
    }
}
