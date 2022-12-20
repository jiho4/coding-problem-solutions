package leetcode;

/**
 * 867. Transpose Matrix
 * https://leetcode.com/problems/transpose-matrix/submissions/712547152/
 * solved: 2022-06-02
 */
class Solution {
    public int[][] transpose(int[][] matrix) {
        int[][] ans = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                ans[j][i] = matrix[i][j];
            }
        }

        return ans;
    }
}
