package leetcode;

import java.util.*;

/**
 * 792. Number of Matching Subsequences
 * https://leetcode.com/problems/number-of-matching-subsequences/submissions/751798070/
 * solved: 2022-07-20
 */
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        Map<Character, Queue<Word>> map = new HashMap<>();

        // initialize the map with queue
        for (char c = 'a'; c <= 'z'; c++) {
            map.put(c, new LinkedList<>());
        }

        // put all words into queue of each char
        for (String w : words) {
            map.get(w.charAt(0)).add(new Word(w, 0));
        }

        for (char c : s.toCharArray()) {
            Queue<Word> q = map.get(c);

            // need to fix the size before processing
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Word w = q.poll();
                w.index++;
                if (w.index == w.word.length()) {
                    count++;
                } else {
                    map.get(w.word.charAt(w.index)).add(w);
                }
            }
        }

        return count;
    }

    class Word {
        String word;
        int index;

        public Word(String s, int i) {
            word = s;
            index = i;
        }
    }
}

// it works, but time limit exceeded
// class Solution {
//     public int numMatchingSubseq(String s, String[] words) {
//         int count = 0;
//         int[] index = new int[words.length];

//         for (int i = 0; i < s.length(); i++) {
//             char c = s.charAt(i);

//             for (int j = 0; j < words.length; j++) {
//                 if (index[j] != words[j].length()
//                     && c == words[j].charAt(index[j])) {
//                     index[j]++;
//                 } else {}
//             }
//         }

//         for (int i = 0; i < words.length; i++) {
//             if (index[i] == words[i].length()) {
//                 count++;
//             } else {}
//         }

//         return count;
//     }
// }
