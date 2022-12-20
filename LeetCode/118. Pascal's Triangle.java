package leetcode;

import java.util.*;

/**
 * 118. Pascal's Triangle
 * https://leetcode.com/problems/pascals-triangle/submissions/751251717/
 * solved: 2022-07-19
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            if (i == 0) {
                row.add(1);
            } else {
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                        row.add(1);
                    } else {
                        row.add(list.get(i - 1).get(j - 1)
                               + list.get(i - 1).get(j));
                    }
                }
            }

            list.add(row);
        }

        return list;
    }
}
