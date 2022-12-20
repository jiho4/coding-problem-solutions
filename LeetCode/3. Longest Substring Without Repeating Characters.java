package leetcode;

import java.util.*;

/**
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/718878153/
 * solved: 2022-06-10
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxLength = 0;
        int window = 1;

        while (right < s.length()) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

            if (map.size() == window) {
                maxLength = Math.max(maxLength, window);
            } else if (map.size() < window) {
                while (map.size() < window) {
                    map.replace(s.charAt(left), map.get(s.charAt(left)) - 1);
                    if (map.get(s.charAt(left)) == 0) {
                        map.remove(s.charAt(left));
                    } else {}

                    left++;
                    window--;
                }
            } else {}

            right++;
            window++;
        }

        return maxLength;
    }
}

// first try
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int maxLength = 0;
//         char[] arr = s.toCharArray();

//         for (int i = 0; i < arr.length; i++) {
//             int length = 0;
//             List<Character> list = new ArrayList<Character>();

//             for (int j = i; j < arr.length; j++) {
//                 if (list.contains(arr[j])) {
//                     break;
//                 } else {
//                     list.add(arr[j]);
//                     length++;
//                 }
//             }

//             maxLength = maxLength > length ? maxLength : length;

//             if (maxLength > arr.length - i) {
//                 break;
//             } else {}
//         }

//         return maxLength;
//     }
// }
