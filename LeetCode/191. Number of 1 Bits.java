package leetcode;

/**
 * 191. Number of 1 Bits
 * https://leetcode.com/problems/number-of-1-bits/submissions/707639591/
 * solved: 2022-05-26
 */
class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            // count += n & 1;
            // n = n >> 1;

            n = n & (n-1);
            count++;
        }

        return count;
    }
}
