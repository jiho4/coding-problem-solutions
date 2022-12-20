package leetcode;

/**
 * 1332. Remove Palindromic Subsequences
 * https://leetcode.com/problems/remove-palindromic-subsequences/submissions/717107988/
 * solved: 2022-06-08
 */
class Solution {
    public int removePalindromeSub(String s) {
        // minimum subsequence is one (since s.length >= 1)
        // maximum subsequence is two (remove all a, then b)
        if (s.equals(new StringBuilder(s).reverse().toString())) {
            return 1;
        } else {
            return 2;
        }
    }
}
