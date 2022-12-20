package leetcode;

/**
 * 1689. Partitioning Into Minimum Number Of Deci-Binary Numbers
 * https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/submissions/732318362/
 * solved: 2022-06-27
 */
class Solution {
    public int minPartitions(String n) {
        int ans = 0;

        for (int i = 0; i < n.length(); i++) {
            ans = Math.max(ans, Character.getNumericValue(n.charAt(i)));

            if (ans == 9) {
                break;
            } else;
        }

        return ans;
    }
}
