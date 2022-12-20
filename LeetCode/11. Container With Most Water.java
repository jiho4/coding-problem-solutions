package leetcode;

/**
 * 11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/submissions/705341600/
 * solved: 2022-05-23
 */
class Solution {
    public int maxArea(int[] height) {
        int leftEdge = 0;
        int rightEdge = height.length - 1;

        int maxAmount = 0;

        while (leftEdge < rightEdge) {
            int width = rightEdge - leftEdge;
            int amount = Math.min(height[leftEdge], height[rightEdge]) * width;

            maxAmount = Math.max(maxAmount, amount);

            if (height[leftEdge] < height[rightEdge]) {
                leftEdge++;
            } else {
                rightEdge--;
            }
        }

        return maxAmount;
    }
}
