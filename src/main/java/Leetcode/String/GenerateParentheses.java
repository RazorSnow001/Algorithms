package Leetcode.String;

import java.util.ArrayList;
import java.util.List;

/*so 1 for this problem ok
 * we want to find  all the know valid parentheses ok
 * so the solution set have multiple solution ((())) that is a solution
 * and ()()() is a solution too
 * so x1 = ( or )
 * x2 = ( or )
 * and so on, but we have constraints
 * so  the overall number of both ( and ) will be n
 * 2 valid
 *
 * */
public class GenerateParentheses {
    int leftBracketNum;
    int rightBracketNum;
    int input;
    StringBuffer stringBuffer;
    List<String> resultList = new ArrayList<>();

    public GenerateParentheses(int num) {
        this.input = num;
        this.leftBracketNum = 0;
        this.rightBracketNum = 0;
        this.stringBuffer = new StringBuffer();
    }

    public void generate() {
        if (leftBracketNum == input && rightBracketNum == input) {
            ValidParentheses validParentheses = new ValidParentheses();
            if (validParentheses.isValid(stringBuffer.toString())) {
                resultList.add(stringBuffer.toString());
            }
        }
        if (leftBracketNum != input) {
            stringBuffer.append("(");
            leftBracketNum++;
            generate();
            leftBracketNum--;
            stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length());
        }
        if (rightBracketNum != input) {
            stringBuffer.append(")");
            rightBracketNum++;
            generate();
            rightBracketNum--;
            stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length());
        }
    }

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses(2);
        generateParentheses.generate();
        System.out.println(generateParentheses.resultList);
    }
}
