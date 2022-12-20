package leetcode;

import java.util.*;

/**
 * 869. Reordered Power of 2
 * https://leetcode.com/problems/reordered-power-of-2/submissions/784754498/
 * solved: 2022-08-27
 */
class Solution {
    public boolean reorderedPowerOf2(int n) {
        char[] target = sortNumAsCharArr(n);

        // regarding the constraint of n, the maximum power of 2 is 30
        for (int i = 0; i <= 30; i++) {
        // if numbers have the same composition of digits,
        // then we can reorder it to the same number
            if (Arrays.equals(target, sortNumAsCharArr((int)Math.pow(2, i)))) {
                return true;
            }
        }

        return false;
    }

    // convert input number 'n' to a sorted char array having each digit numbers
    private char[] sortNumAsCharArr(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        Arrays.sort(arr);
        return arr;
    }
}
