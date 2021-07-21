package RecursionRelated.DynamicProgramming.GreedyAlgorithm;

import java.util.ArrayList;
import java.util.List;
/*ok 1 we have noticed that --- a greedy algorithm can reduce the branches of the
*  dynamic programming . we just consider the best choice .so we just remain only
*  one selection . so the main case of the greedy algorithms is why ? not how ?
*  we have noticed that if you just look the current best choice .may leads to a
*  no global best choice .that is the case . but why ? that is the reason we needs to
*  read the books . ok that is very fascinating !
*  why we can use the dynamic programming for this problem .
*  that is --- ok
*  use the proof by contradiction to get the conclusion --- we can use the DP
*  so suppose Aij contains the solution which we talk about --- Sij which is another set
*  to contain the best answer . and maybe we have more than one option for the best answer
*  equal !
*  after the hard work we have find a very useful key to analyze both the greedy and
*  dynamic programming and even the back tracing problem . that is very great ! my boy
*  the solution set can have both flexible size or the fixed size . that is really great
*  but the key is
*  if we use the solution set to analyze the problem here
*     1 if we just want all the valid cases . we should use the back tracing algorithm to find all
*       if not valid or just to the base case . we can just back trace and search further !
*     2 if we want the optimal solution ?
*       DP and greedy we say --- ok just candidate approach !
*       so now we noticed the overlapping sub problem  and the  optimal structure
*       which means the big problem's optimal solution will depend on the smaller
*       sub problem's result . and the dp always in a bottom to up style .
*       the global optimal will depend on the future sub problem result
*       . and now we can see how to demonstrate the optimal structure .
*       actually we make choice  from the solution set .
*       which is where the sub problem comes from .
*       the main logic is. ok suppose that the current selection ------- we suppose this item
*       is in the optimal result set .
*       but that is just some kind of hypothesis
*       so compare is needed . so that is just some kind of process to determine
*       if the current selection . the potential solution component is in the optimal solution set.
*       so if we can demonstrate one problem ----- optimal problem or some kind of matching problem
*       have overlapping sub problem and  the optimal structure . we can try the DP for the
*       construction .
*       but hold on . DP is great but maybe we can push further . reduce the branches .
*       reduce the selection . that will lead to the greedy method .
*       but if you want to try greedy . that is a little bit dangerous .
*       because you have to demonstrate . every time you select the base at current the
*       potential item will be in the optimal solution set . is actually in the optimal solution set .
*
*       so like the activitySelection problem .
*       Sk means the input have all the activities we can try
*       Ak means the optimal solution set
*       so Ak belongs to Sk and Ak maybe not just one
*       Ak1 = Ak2 = Ak3
*       now we just need to prove if the a1 is the greedy selection in Sk
*       a1 will be in the Ak
*       a1= aj not need to prove !
*       a1!=aj s1<=sj
        because the s1 is the global min
        so if we replace the sj with the si
        we got the A1 will >= Ak
        that conflicts the big presupposition
        Ak is the optimal solution set
        so A1 = Ak
        and s1 = sj

        after get that we have proved every potential greedy item will be in the
        optimal solution set .
        and if we have just verify the current state si is exactly the item in the optimal
        solution set .
*
*
*   */
public class ActivitySelection {
    private List<Activity> activities = new ArrayList<>();
    public void getTheBestActivities() {

    }
}
