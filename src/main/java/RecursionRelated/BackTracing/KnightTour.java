package RecursionRelated.BackTracing;

import akka.japi.Pair;

import java.util.List;

/*1 what is the constraint of the problem ?
 *   ok the constraint is the
 *       1  the movement of the knight
 *       2  the boundary condition which also limit the knight movements
 *       3  each square can have only single number , no repeat numbers ---- each position we travel just once !
 *       so the constraint will influence the solution set !
 *   suppose we have a solution !
 *   which contains the fixed size of the solution set x1  to x64
 *   and what is the value of that ?
 *   and we already know the x0 is 1 .
 *   [x0,x1,x2.......x63]
 *   that is very great !
 *   and the value for the selection of xi is setB{ 1 to 64 }
 *   and each step the value ++ but the x i ?  i is not with the fixed order . so we search the
 *   xi for push the setB value into the xi
 *   AND
 *   WHERE  IS THE  the end base condition of the search
 *   ？
 *   we get the 64 ! ?
 *   but such modeling maybe hard to code
 *   so after the sleep we got another modeling !
 *   so this time we use the
 *   x1 x2 ... x64 for the step and the
 *   value of the xi is the position of the step i
 *   this modeling seems more potential !
 *   and that is matching the node graph of the code !
 *
 *   so the layer indicates the step and the node value  represents the location !
 *   so the best the way to local the position so the value should be row and column
 *   so the solution is use the constraints to computing the next xi
 *   and use the backTracing to find the solution !
 *
 *   so the core code will be using the constraint to compute the set of the next choices of the xi
 *
 *  */
public class KnightTour {
    int[][] tourMap = new int[8][8];
    int step = 0;

    public void findTheSolution() {


    }

    /**  with this method we will use the constraints to compute all the potential values for the next back tracing !
     *   but how to do that ?
     *          1  the movement of the knight
     *  *       2  the boundary condition which also limit the knight movements
     *  *       3  each square can have only single number , no repeat numbers ---- each position we travel just once ! */
    public List<Pair<Integer,Integer>> findTheValueSet(){

    }

}
