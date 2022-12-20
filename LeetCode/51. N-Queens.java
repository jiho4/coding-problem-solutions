package leetcode;

import java.util.*;

/**
 * 51. N-Queens
 * https://leetcode.com/problems/n-queens/submissions/714820254/
 * solved: 2022-06-05
 */
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        int[] rows = new int[n];

        backtrack(res, rows, n, 0);

        return res;
    }

    // check the combinations of Queen positions from 1x1 to NxN
    private void backtrack(List<List<String>> res, int[] rows, int target, int level) {

        if (level == target) {
            res.add(converter(rows, target));

        } else {
            // 'i' means the position of Queen's column at 'level' row
            for (int i = 0; i < target; i++) {
                rows[level] = i;

                if (isValid(rows, level)) {
                    // call again to find the valid combination for the next row
                    backtrack(res, rows, target, level+1);
                } else {}
            }
        }
    }

    // check if Queen's positions of current level is valid
    private boolean isValid(int[] rows, int level) {
        for (int i = 0; i < level; i++) {
            // check if it is on same column, or on the same diagonal
            if (rows[i] == rows[level]
               || Math.abs(level - i) == Math.abs(rows[level] - rows[i])) {
                return false;
            } else {}
        }

        return true;
    }

    // convert the number in rows into the list of strings
    private List<String> converter(int[] rows, int target) {
        List<String> list = new ArrayList<String>();
        char[] charArr = new char[target];

        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < target; j++) {
                if (j == rows[i]) {
                    charArr[j] = 'Q';
                } else {
                    charArr[j] = '.';
                }
            }

            list.add(new String(charArr));
        }

        return list;
    }
}
