package leetcode;

import java.util.*;

/**
 * 78. Subsets
 * https://leetcode.com/problems/subsets/submissions/785237231/
 * solved: 2022-08-28
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<Integer>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list
                           , List<Integer> tempList
                           , int[] nums
                           , int n) {

        list.add(new ArrayList<>(tempList));

        for (; n < nums.length; n++) {
            tempList.add(nums[n]);
            backtrack(list, tempList, nums, n + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
