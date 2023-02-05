package leetcode;

import java.util.*;

/**
 * 438. Find All Anagrams in a String
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/submissions/892056429/
 * solved: 2023-02-05
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        int[] freqArr = new int[26];
        int[] iterArr = new int[26];

        if (s.length() < p.length()) {
            return ans;
        }

        for (int i = 0; i < p.length(); i++) {
            freqArr[p.charAt(i) - 'a']++;
            iterArr[s.charAt(i) - 'a']++;
        }

        // using sliding window
        int left = 0;
        int right = p.length() - 1;
        for (; left <= s.length() - p.length(); left++, right++) {
            if (freqArr[s.charAt(right) - 'a'] != 0 && isFreqSame(freqArr, iterArr)) {
                ans.add(left);
            }

            if (right == s.length() - 1) {
                break;
            }

            iterArr[s.charAt(left) - 'a']--;
            iterArr[s.charAt(right+1) - 'a']++;
        }

        return ans;
    }

    private boolean isFreqSame(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }
}
