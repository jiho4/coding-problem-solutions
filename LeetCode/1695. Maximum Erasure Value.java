package leetcode;

import java.util.*;

/**
 * 1695. Maximum Erasure Value
 * https://leetcode.com/problems/maximum-erasure-value/submissions/720901030/
 * solved: 2022-06-12
 */
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        // List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        int maxSum = 0;
        int sum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (set.contains(nums[right])) {
                while (set.contains(nums[right])) {
                    sum -= nums[left];
                    set.remove(nums[left]);
                    left++;
                }
            } else {}

            sum += nums[right];
            set.add(nums[right]);
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}
