package Leetcode.String;


import java.util.Arrays;
import java.util.List;

/*
*  here we go . we have 3 approaches to solve this problem
*  which indicates
*  1 row traverse of the element . and we can find the max common prefix of  two adjacent string .
*    that is just ok
*    for example if we have abcde abcbf abgd
*    so if we search the common prefix of the 1 and 2 we get the abc
*    if we search the 2 and 3 we get the ab
*    so ab < abc we update the common prefix to ab
*    if once the common prefix equals to the " "
*    or the length of the common prefix is 0 we end the execution at once !
*    that is quite a great method !
*
* 2 column scan is a little different method . in this case we need to
*   get all the elements .
*   get their first char
*   compare and if all the first char of the elements are equivalent
*   if we get ture we add this char to the ultimate result
*   we move to the next condition .
*   this time we find .ok
*   not all char of the specific position are equivalent
*   we end the execution and then !
*   output the result !
*
* 3 the third method is use the divide and conquer algorithm
*   which means we can divide the list of the string elements to two sub list and each one return the
*   common prefix ?
*   so in this case we will use the base condition to divide the problem .
*   so ?
*   what is the base condition ?
*   if  we have two elements and what we got is ?
*   that is exactly like the method 1 . we get the common prefix of the two elements
*   and further more
*   if we just have one element
*   how to deal with that  ？
*   ok if we just have one element for this subproblem
*   we need to use the entire element as the*
!   common prefix  !
*
* */
public class LongestCommonPrefix {
    public String getTheCommonPrefix(List<String> elements, int head, int end) {
        if (end - head == 1) {
            return getTheCommonPrefixOfTwoString(elements.get(head), elements.get(end));
        }
        if (head == end) {
            return elements.get(head);
        }

        int mid = (head + end) / 2;

        String leftCommonPrefix = getTheCommonPrefix(elements, head, mid);
        String rightCommonPrefix = getTheCommonPrefix(elements, mid + 1, end);
        return getTheCommonPrefixOfTwoString(leftCommonPrefix, rightCommonPrefix);
    }

    public String getTheCommonPrefixOfTwoString(String first, String second) {
        StringBuilder result = new StringBuilder();
        int indexOfFisrt = 0;
        int indexOfSecond = 0;
        int lengthOfFirst = first.length();
        int lengthOfSecond = second.length();
        while (indexOfFisrt != lengthOfFirst && indexOfSecond != lengthOfSecond) {
            if (first.charAt(indexOfFisrt) == second.charAt(indexOfSecond)) {
                result.append(first.charAt(indexOfFisrt));
                indexOfFisrt++;
                indexOfSecond++;
            } else {
                return result.toString();
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("abcde", "abchg", "abcjj", "abcoiiyu", "abcoii", "abco", "abcd");
        LongestCommonPrefix execute = new LongestCommonPrefix();
        String commonPrefix = execute.getTheCommonPrefix(input, 0, input.size() - 1);
        System.out.println(commonPrefix);
    }
}
