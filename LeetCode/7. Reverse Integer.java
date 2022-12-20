package leetcode;

/**
 * 7. Reverse Integer
 * https://leetcode.com/problems/reverse-integer/submissions/560677901/
 * solved: 2021-09-25
 */
class Solution {
    public int reverse(int x) {
        int reversedInt = 0;

        while (x != 0) {
            // if overflow happens, then number will not match
            if (reversedInt != (reversedInt * 10) / 10) {
                return 0;
            }

            // add the last digit of x to reversedInt
            reversedInt *= 10;
            reversedInt += x % 10;

            // remove the last digit
            x = x / 10;
        }

        return reversedInt;
    }
}
