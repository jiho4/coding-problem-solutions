package leetcode;

import java.util.*;

/**
 * 6. Zigzag Conversion
 * https://leetcode.com/problems/zigzag-conversion/submissions/863931555/
 * solved: 2022-12-22
 */
class Solution {
    public String convert(String s, int numRows) {
        List<StringBuilder> subStringList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        final int iteration = (numRows - 1) * 2;
        int cursor = 0;

        if (numRows == 1) {
            return s;
        }

        // make StringBuilders to contain each rows
        for (int i = 0; i < numRows; i++) {
            subStringList.add(new StringBuilder());
        }

        // put each char of s into the certain row
        for (int i = 0; i < s.length(); i++) {
            if (cursor == iteration) {
                cursor = 0;
            } else {}

            if (cursor < numRows) {
                subStringList.get(cursor).append(s.charAt(i));
            } else {
                subStringList.get(iteration - cursor).append(s.charAt(i));
            }

            cursor++;
        }

        // concat every rows to sb
        for (int i = 0; i < numRows; i++) {
            // System.out.println(subStringList.get(i));
            sb.append(subStringList.get(i));
        }

        return sb.toString();
    }
}
