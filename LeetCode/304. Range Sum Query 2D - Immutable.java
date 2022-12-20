package leetcode;

/**
 * 304. Range Sum Query 2D - Immutable
 * https://leetcode.com/problems/range-sum-query-2d-immutable/submissions/713519845/
 * solved: 2022-06-03
 */
class NumMatrix {

    private int[][] arr;

    public NumMatrix(int[][] matrix) {
        arr = new int[matrix.length+1][matrix[0].length+1];

        for (int i = 0; i <= matrix.length; i++) {
            arr[i][0] = 0; // initialize first row to 0

            for (int j = 0; j <= matrix[0].length; j++) {
                arr[0][j] = 0; // initialize first col to 0

                if (i > 0 && j > 0) {
                    arr[i][j]
                        = arr[i-1][j] + arr[i][j-1]
                        - arr[i-1][j-1]
                        + matrix[i-1][j-1];
                } else {}
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return arr[row2+1][col2+1]
            - arr[row2+1][col1] - arr[row1][col2+1]
            + arr[row1][col1];
    }
}

/**
 * (constraints)
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */