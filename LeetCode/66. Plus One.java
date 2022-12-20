package leetcode;

/**
 * 66. Plus One
 * https://leetcode.com/problems/plus-one/submissions/559707152/
 * solved: 2021-09-23
 */
class Solution {
    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + 1 == 10) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                break;
            }
        }

        // if the first value is 0, it means that the large integer become 100000...
        if (digits[0] == 0) {
            digits = new int[digits.length + 1]; // initial value of int[] is [0, 0, 0...]
            digits[0] = 1;
        } else {}

        return digits;
    }
}
