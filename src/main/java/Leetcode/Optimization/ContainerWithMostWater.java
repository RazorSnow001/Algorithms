package Leetcode.Optimization;

/*ok
 * Area = min(height_left,height_right)*(height_right_index-height_left_index)
 * 1 use the brute way --- use the two loop to find every left and right index --- compare find the
 * min height and find the corresponding area and compare
 * 2 but we see the area function ok  how to use the property to reduce some
 * redundancy computing
 * so we have another way to handle the array two index traverse with condition
 * longer width or smaller width with longer height so we can find the overall max .
 * */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0, left = 0, right = height.length - 1;
        while (left < right) {
            maxArea = Math.max(maxArea, Math.max(height[left], height[right]) * (right - left));
            if (height[left] < height[right])
                left++;
            else
                right++;
        }
        return maxArea;
    }
}
