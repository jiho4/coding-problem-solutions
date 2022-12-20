package leetcode;

/**
 * 70. Climbing Stairs
 * https://leetcode.com/problems/climbing-stairs/submissions/561155651/
 * solved: 2021-09-26
 */
class Solution {
    public int climbStairs(int n) {
        return climb(n, new int[n]);
    }

    public int climb(int leftStairs, int[] memory) {
        // end condition of the recursion
        if (leftStairs <= 2) {
            return leftStairs;
        } else {
            if (memory[leftStairs - 1] == 0) {
                // since we can climb 1 or 2 steps at a time,
                // ways of climb n stairs == (climb n-1 stairs + 1 stair) + (climb n-2 stairs + 2 stairs)
                memory[leftStairs - 1] = climb(leftStairs - 1, memory) + climb(leftStairs - 2, memory);
            } else {}

            return memory[leftStairs - 1];
        }
    }
}
