package leetcode;

// import java.util.*;

/**
 * 1061. Lexicographically Smallest Equivalent String
 * https://leetcode.com/problems/lexicographically-smallest-equivalent-string/submissions/878167325/
 * solved: 2023-01-14
 */
class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        // index of dict represents each alphabet
        // each element of dict represents the smallest eqv char of that alphabet
        char[] dict = new char[26];
        for (char c = 'a'; c <= 'z'; c++) {
            dict[c - 'a'] = c;
        }

        // find the smallest eqv char for each alphabet
        for (int i = 0; i < s1.length(); i++) {
            // c1 and c2 are eqv chars
            char c1 = dict[s1.charAt(i) - 'a'];
            char c2 = dict[s2.charAt(i) - 'a'];

            if (c1 == c2) {
                continue;
            } else {
                // sort c1, c2
                if (c1 > c2) {
                    char temp = c1;
                    c1 = c2;
                    c2 = temp;
                }

                // replace all c2 to c1, the smaller eqv char
                for (int j = 0; j < dict.length; j++) {
                    if (dict[j] == c2) {
                        dict[j] = c1;
                    }
                }
            }
        }

        // replace each char to the smallest eqv char
        StringBuilder sb = new StringBuilder(baseStr);
        for (int i = 0; i < sb.length(); i++) {
            sb.setCharAt(i, dict[sb.charAt(i) - 'a']);
        }

        return sb.toString();
    }
}

// *first try
// class Solution {
//     public String smallestEquivalentString(String s1, String s2, String baseStr) {
//         Map<Character, SortedSet<Character>> map = new HashMap<>();

//         createEqvCharMap(s1, s2, map);

//         return replaceToSmallestEqvString(baseStr, map);
//     }

//     private void createEqvCharMap(
//         String s1,
//         String s2,
//         Map<Character, SortedSet<Character>> map) {
//         // create a List of Set for each equivalent chars
//         for (int i = 0; i < s1.length(); i++) {
//             // c1 and c2 are eqv chars
//             char c1 = s1.charAt(i);
//             char c2 = s2.charAt(i);

//             if (c1 == c2) {
//                 continue;
//             }

//             // map has no c1, c2
//             if (!map.containsKey(c1) && !map.containsKey(c2)) {
//                 // initialize
//                 SortedSet<Character> set = new TreeSet<>();
//                 set.add(c1);
//                 set.add(c2);
//                 map.put(c1, set);
//                 map.put(c2, set);
//             // map has both c1, c2
//             } else if (map.containsKey(c1) && map.containsKey(c2)) {
//                 // c1 and c2 are eqv, but stored in different set
//                 if (map.get(c1) != map.get(c2)) {
//                     map.get(c1).addAll(map.get(c2)); // merge two set

//                     // update each char in set of c2, to point merged set
//                     for (char c : map.get(c2)) {
//                         map.put(c, map.get(c1));
//                     }
//                 }
//             // map has no c1
//             } else if (!map.containsKey(c1)) {
//                 map.get(c2).add(c1);
//                 map.put(c1, map.get(c2));
//             // map has no c2
//             } else if (!map.containsKey(c2)) {
//                 map.get(c1).add(c2);
//                 map.put(c2, map.get(c1));
//             } else {}
//         }
//     }

//     private String replaceToSmallestEqvString(
//         String baseStr,
//         Map<Character, SortedSet<Character>> map) {
//         // replace each char to smallest one
//         StringBuilder sb = new StringBuilder(baseStr);
//         for (int i = 0; i < sb.length(); i++) {
//             char c = sb.charAt(i);
//             if (map.containsKey(c)) {
//                 char eqvSmallestChar = map.get(c).first();

//                 if (c != eqvSmallestChar) {
//                     sb.setCharAt(i, eqvSmallestChar);
//                 }
//             } else {}
//         }

//         return sb.toString();
//     }
// }
