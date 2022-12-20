package leetcode;

import java.util.*;

/**
 * 22. Generate Parentheses
 * https://leetcode.com/problems/generate-parentheses/submissions/706701487/
 * solved: 2022-05-25
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<String>();

        backtrack(combinations, "", 0, 0, n);

        return combinations;
    }

    private void backtrack(List<String> combinations, String combination
                           ,int open, int close, int max) {
        if (combination.length() == max*2) {
            combinations.add(combination);

        } else {
            if (open < max) {
                backtrack(combinations, combination+"(", open+1, close, max);
            } else {}

            if (close < open) {
                backtrack(combinations, combination+")", open, close+1, max);
            } else {}
        }

        return;
    }

    /*
    10

    1100 > A
    1010 > B

    111000 > 1A0
    110100 > 1B0
    110010 > A10
    101100 > 10A
    101010 > 10B, B10
    */
}
