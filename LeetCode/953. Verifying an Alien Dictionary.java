package leetcode;

import java.util.*;

/**
 * 953. Verifying an Alien Dictionary
 * https://leetcode.com/problems/verifying-an-alien-dictionary/submissions/889854492/
 * solved: 2023-02-02
 */
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> dict = new HashMap<>();

        // mapping the alien alphabet order
        for (int i = 0; i < order.length(); i++) {
            dict.put(order.charAt(i), i);
        }

        // iterate for each word
        for (int i = 0; i < words.length - 1; i++) {
            // compare the character at j position of each word
            for (int j = 0; j < words[i].length(); j++) {
                if (j >= words[i + 1].length()) {
                    return false;
                }

                if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                    if (dict.get(words[i].charAt(j)) > dict.get(words[i+1].charAt(j))) {
                        return false;
                    } else {
                        break;
                    }
                }
            }
        }

        return true;
    }
}
