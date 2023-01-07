package leetcode;

/**
 * 134. Gas Station
 * https://leetcode.com/problems/gas-station/submissions/873079122/
 * solved: 2023-01-07
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalRemainingGas = 0;
        int remainingGas = 0;
        int startingPoint = 0;

        for (int i = 0; i < gas.length; i++) {
            totalRemainingGas += gas[i] - cost[i];
            remainingGas += gas[i] - cost[i];

            if (remainingGas < 0) {
                remainingGas = 0;
                startingPoint = i + 1;
            }
        }

        return totalRemainingGas < 0 ? -1 : startingPoint;
    }
}
