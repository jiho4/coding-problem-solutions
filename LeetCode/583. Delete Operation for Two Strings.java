package leetcode;

/**
 * 583. Delete Operation for Two Strings
 * https://leetcode.com/problems/delete-operation-for-two-strings/submissions/721883009/
 * solved: 2022-06-14
 */
// referred to the below solution
// https://leetcode.com/problems/delete-operation-for-two-strings/discuss/1195726/C%2B%2BPythonJava-Short-and-Easy-Solutions-w-Explanation-or-Optimization-from-Brute-Force-to-DP
class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[2][word2.length() + 1];

        for (int i = 0; i < word1.length() + 1; i++) {
            for (int j = 0; j < word2.length() + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i & 1][j] = i + j;
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i & 1][j] = dp[(i - 1) & 1][j - 1];
                } else {
                    dp[i & 1][j] = 1 + Math.min(dp[(i - 1) & 1][j], dp[i & 1][j - 1]);
                }
            }
        }

        return dp[word1.length() & 1][word2.length()];
    }
}
