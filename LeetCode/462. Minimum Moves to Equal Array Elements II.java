package leetcode;

import java.util.*;

/**
 * 462. Minimum Moves to Equal Array Elements II
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/submissions/734776659/
 * solved: 2022-06-30
 */
class Solution {
    public int minMoves2(int[] nums) {
        int median;
        int moveCount = 0;

        Arrays.sort(nums);

        median = nums[(nums.length / 2)];

        // calculate the number of moves
        for (int i = 0; i < nums.length; i++) {
            moveCount += Math.abs(median - nums[i]);
        }

        return moveCount;
    }
}
