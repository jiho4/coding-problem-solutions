package leetcode;

import java.util.*;

/**
 * 473. Matchsticks to Square
 * https://leetcode.com/problems/matchsticks-to-square/submissions/745803737/
 * solved: 2022-07-13
 */
class Solution {
    public boolean makesquare(int[] matchsticks) {
        // get 4 partitions of the equal sum of subsets
        int TARGET_PARTITIONS = 4;

        int sum = 0;

        for (int length : matchsticks) sum += length;

        // check base conditions
        if (matchsticks.length < TARGET_PARTITIONS
            || sum % TARGET_PARTITIONS != 0) {
            return false;
        } else {
            // sort by descending order
            Arrays.sort(matchsticks);
            reverseOrder(matchsticks);

            // if the largest stick is bigger than one side, return false
            if (matchsticks[0] > sum / TARGET_PARTITIONS) return false;

            // try dfs
            return dfs(matchsticks, new int[TARGET_PARTITIONS], 0
                       , sum / TARGET_PARTITIONS);
        }
    }

    private boolean dfs(int[] matches, int[] subsets, int index, int target) {
        if (index == matches.length) {
            return true;
        } else {
            for (int i = 0; i < subsets.length; i++) {
                if (subsets[i] + matches[index] > target
                   || isAlreadyChecked(subsets, i)) {
                    continue;
                } else {
                    subsets[i] += matches[index];
                    if (dfs(matches, subsets, index + 1, target))
                        return true;
                    subsets[i] -= matches[index];
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
