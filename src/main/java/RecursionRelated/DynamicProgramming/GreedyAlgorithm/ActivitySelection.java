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
*       we use the  proof by contradiction to get the optimal sub construction
*       that is really cool
*       if cij = max {cik + ckj + 1}
*       that means the cik and ckj represents the optimal solution too
*       if not you mean . that .  cik is not the optimal solution .
*       so we can find cij' > cik and so cik'+ckj +1 > cij
*       which conflict the assumption that cij is the optimal solution . paste
*       and contradiction method is the general method to get the you know
*       the optimal sub construction .
*
*       and in the greedy method . first thing you need to know is . yes this problem
*       is powerful but also dangerous . if you can't prove each greedy selection is
*       ----- the element may be in the optimal solution set .and even you prove that .
*       using the greedy you got the optimal solution but not all the optimal solution
*       so using the greedy algorithm you can get it maybe even not one . but
*       that is the sub set of the corresponding dynamic programming result . ok
*
*
*
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
