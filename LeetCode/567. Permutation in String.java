package leetcode;

import java.util.*;

/**
 * 567. Permutation in String
 * https://leetcode.com/problems/permutation-in-string/submissions/891057578/
 * solved: 2023-02-04
 */
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] baseCharArr = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            baseCharArr[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            if (baseCharArr[s2.charAt(i) - 'a'] != 0) {
                int counter = 0;
                int[] charArr = baseCharArr.clone();

                for (int j = 0; j < s1.length(); j++) {
                    if (charArr[s2.charAt(i+j) - 'a'] == 0) {
                        break;
                    } else {
                        counter++;
                        charArr[s2.charAt(i+j) - 'a']--;
                    }

                    if (counter == s1.length()) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
