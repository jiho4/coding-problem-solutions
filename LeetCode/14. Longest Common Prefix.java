package leetcode;

/**
 * 14. Longest Common Prefix
 * https://leetcode.com/problems/longest-common-prefix/submissions/726698924/
 * solved: 2022-06-20
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minWordLength = Integer.MAX_VALUE;
        boolean isCommonPrefix = true;
        StringBuilder sb = new StringBuilder();

        // find a minimum length of all strings
        // (maximum of common prefix cannot be bigger than minimum length)
        for (String word: strs) {
            minWordLength = Math.min(minWordLength, word.length());
        }

        for (int i = 0; i < minWordLength; i++) {
            char currentChar = strs[0].charAt(i);

            // all word should have same char at i to become 'commonPrefix'
            for (String word: strs) {
                if (word.charAt(i) != currentChar) {
                    isCommonPrefix = false;
                    break;
                } else {}
            }

            // if all strings have same char at i, append it
            if (isCommonPrefix == true) {
                sb.append(currentChar);
            } else {
                // break the loop
                break;
            }
        }

        return sb.toString();
    }
}
