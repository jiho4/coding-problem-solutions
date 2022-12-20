package leetcode;

import java.util.*;

/**
 * 39. Combination Sum
 * https://leetcode.com/problems/combination-sum/submissions/561122929/
 * solved: 2021-09-26
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();

        findCombinations(combinations, candidates, new ArrayList<>(), 0, 0, target);

        return combinations;
    }

    public void findCombinations(List<List<Integer>> combinations, int[] candidates, List<Integer> comb, int index, int sum, int target) {

        // end condition of the recursion
        if (sum >= target || index == candidates.length) {
            // add current combination when hit
            if (sum == target) {
                combinations.add(new ArrayList<>(comb));
                return;
            } else {
                return;
            }
        } else {
            // find combinations again with using the same candidate
            comb.add(candidates[index]);
            sum += candidates[index];
            findCombinations(combinations, candidates, comb, index, sum, target);

            // find combinations without the current candidate
            comb.remove(comb.size() - 1);
            sum -= candidates[index];
            index++;
            findCombinations(combinations, candidates, comb, index, sum, target);
        }
    }
}
