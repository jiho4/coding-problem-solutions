package leetcode;

import java.util.*;

/**
 * 698. Partition to K Equal Sum Subsets
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/submissions/745800270/
 * solved: 2022-07-13
 */
// used same solution of https://leetcode.com/problems/matchsticks-to-square/
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;

        for (int length : nums) sum += length;

        // check base conditions
        if (nums.length < k || sum % k != 0) {
            return false;
        } else {
            // sort by descending order
            Arrays.sort(nums);
            reverseOrder(nums);

            // if the largest num is bigger than sum of the partition, return false
            if (nums[0] > sum / k) return false;

            // try dfs
            return dfs(nums, new int[k], 0, sum / k);
        }
    }

    private boolean dfs(int[] nums, int[] subsets, int index, int target) {
        if (index == nums.length) {
            return true;
        } else {
            for (int i = 0; i < subsets.length; i++) {
                if (subsets[i] + nums[index] > target
                   || isAlreadyChecked(subsets, i)) {
                    continue;
                } else {
                    subsets[i] += nums[index];
                    if (dfs(nums, subsets, index + 1, target))
                        return true;
                    subsets[i] -= nums[index];
                }
            }

            return false;
        }
    }

    private boolean isAlreadyChecked(int[] subsets, int i) {
        for (int j = 0; j < i; j++) {
            if (subsets[i] == subsets[j])
                return true;
        }

        return false;
    }

    private void reverseOrder(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int temp;

        while (left < right) {
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++; right--;
        }
    }
}
