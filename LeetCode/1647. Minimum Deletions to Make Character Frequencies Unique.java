package leetcode;

import java.util.*;

/**
 * 1647. Minimum Deletions to Make Character Frequencies Unique
 * https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/submissions/733619826/
 * solved: 2022-06-28
 */
class Solution {
    public int minDeletions(String s) {
        int deletionCount = 0;
        Map<Character, Integer> map = new HashMap<>();
        Set<Integer> frequencySet = new HashSet<>();


        // map all frequencies of each characters
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        // check frequencies and make them unique
        for (Character key : map.keySet()) {
            int currentFrequency = map.get(key);
            while (currentFrequency > 0) {
                if (frequencySet.contains(currentFrequency)) {
                    currentFrequency--;
                    deletionCount++;
                } else {
                    frequencySet.add(currentFrequency);
                    break;
                }
            }
        }

        return deletionCount;
    }
}
