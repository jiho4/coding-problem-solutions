package leetcode;

/**
 * 326. Power of Three
 * https://leetcode.com/problems/power-of-three/submissions/782042678/
 * solved: 2022-08-24
 */
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return (n == 1);
    }
}
