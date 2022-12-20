package leetcode;

import java.util.*;

/**
 * 1. Two Sum
 * https://leetcode.com/problems/two-sum/submissions/524337707/
 * solved: 2021-07-18
 */
class Solution {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> hashMap = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];

      if (hashMap.containsKey(complement)) {
        return new int[] { hashMap.get(complement), i };
      } else {
        hashMap.put(nums[i], i);
      }
    }

    return null;
  }
}
