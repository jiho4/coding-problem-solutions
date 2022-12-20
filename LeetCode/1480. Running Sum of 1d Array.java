package leetcode;

/**
 * 1480. Running Sum of 1d Array
 * https://leetcode.com/problems/running-sum-of-1d-array/submissions/711751782/
 * solved: 2022-06-01
 */
class Solution {
    public int[] runningSum(int[] nums) {
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                ans[0] += nums[0];
            } else {
                ans[i] += ans[i-1] + nums[i];
            }
        }

        return ans;
    }
}
