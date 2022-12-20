package leetcode;

import java.util.*;

/**
 * 9. Palindrome Number
 * https://leetcode.com/problems/palindrome-number/submissions/558607151/
 * solved: 2021-09-21
 */
class Solution {
    public boolean isPalindrome(int x) {
        int digit = 0;
        List<Integer> arrayList = new ArrayList<>();

        // minus number cannot be palindrome
        if (x < 0) {
            return false;
        } else {}

        // convert integer number to arrayList
        while (x > 0) {
            arrayList.add(x % 10);
            x /= 10;
            digit++;
        }

        // compare forward number and backward number
        for (int i = 0; i < digit/2; i++) {
            if (arrayList.get(i) != arrayList.get(digit - 1 - i)) {
                return false;
            } else {}
        }

        return true;
    }
}
