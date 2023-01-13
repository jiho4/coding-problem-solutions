package leetcode;

import java.util.*;

/**
 * 1078. Occurrences After Bigram
 * https://leetcode.com/problems/occurrences-after-bigram/submissions/877523677/
 * solved: 2023-01-13
 */
class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> ans = new ArrayList<>();
        String[] splited = text.split(" ");

        if (splited.length < 3) {
            return new String[0];
        }

        for (int i = 2; i < splited.length; i++) {
            if (splited[i - 2].equals(first) && splited[i - 1].equals(second)) {
                ans.add(splited[i]);
            }
        }

        return ans.toArray(new String[0]);
    }
}
