package leetcode;

import java.util.*;

/**
 * 944. Delete Columns to Make Sorted
 * https://leetcode.com/problems/delete-columns-to-make-sorted/submissions/870745511/
 * solved: 2023-01-03
 */
class Solution {
    public int minDeletionSize(String[] strs) {
        int count = 0;

        for (int col = 0; col < strs[0].length(); col++) {
            char iterator = 'a';

            for (int row = 0; row < strs.length; row++) {
                if (iterator > strs[row].charAt(col)) {
                    count++;
                    break;
                } else {
                    iterator = strs[row].charAt(col);
                }
            }
        }

        return count;
    }
}
