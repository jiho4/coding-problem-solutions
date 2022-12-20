package leetcode;

/**
 * 746. Min Cost Climbing Stairs
 * https://leetcode.com/problems/min-cost-climbing-stairs/submissions/743420014/
 * solved: 2022-07-10
 */
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] totalCost = new int[cost.length];

        return Math.min(getMinCost(totalCost, cost, cost.length - 1)
                        , getMinCost(totalCost, cost, cost.length - 2));
    }

    private int getMinCost(int[] totalCost, int[] cost, int i) {
        if (i < 0) {
            return 0;
        } else if (i == 0 || i == 1) {
            return cost[i];
        } else if (totalCost[i] != 0) {
            return totalCost[i];
        } else {
            totalCost[i] = cost[i] + Math.min(getMinCost(totalCost, cost, i - 1)
                                              , getMinCost(totalCost, cost, i - 2));
            return totalCost[i];
        }
    }
}
