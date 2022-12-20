package leetcode;

import java.util.*;

/**
 * 1473. Paint House III
 * https://leetcode.com/problems/paint-house-iii/submissions/741618129/
 * solved: 2022-07-08
 */
class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] dp = new int[m][n][target + 1];
        int minCost = Integer.MAX_VALUE;

        // initialize
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);

                if (i == 0) {
                    if (houses[0] == 0) {
                        dp[0][j][1] = cost[0][j];
                    } else if (houses[0] == j + 1) {
                        dp[0][j][1] = 0;
                    } else {}
                } else {}
            }
        }

        // bottom-up approach
        for (int i = 1; i < m; i++) {
            for (int k = 1; k < Math.min(target + 1, i + 2); k++) {
                for (int j = 0; j < n; j++) {
                    if (houses[i] != 0 && houses[i] != j+1) {
                        continue;
                    } else {}

                    int currentCost = houses[i] == j + 1 ? 0 : cost[i][j];

                    for (int prvJ = 0; prvJ < n; prvJ++) {
                        if (prvJ == j
                            && dp[i-1][prvJ][k] != Integer.MAX_VALUE) {
                            dp[i][j][k] = Math.min(dp[i][j][k]
                                                   ,currentCost + dp[i-1][j][k]);
                        } else if (prvJ != j
                                   && dp[i-1][prvJ][k-1] != Integer.MAX_VALUE) {
                            dp[i][j][k] = Math.min(dp[i][j][k]
                                                   ,currentCost + dp[i-1][prvJ][k-1]);
                        } else {}
                    }
                }
            }
        }

        // find minimum cost
        for (int j = 0; j < n; j++) {
            if (dp[m-1][j][target] != Integer.MAX_VALUE) {
                minCost = Math.min(minCost, dp[m-1][j][target]);
            } else {}
        }

        // possible maximum cost is 100000 according to the constraints
        if (minCost > 1e6) {
            return -1;
        } else {
            return minCost;
        }
    }
}
