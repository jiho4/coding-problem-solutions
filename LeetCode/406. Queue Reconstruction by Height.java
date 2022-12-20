package leetcode;

import java.util.*;

/**
 * 406. Queue Reconstruction by Height
 * https://leetcode.com/problems/queue-reconstruction-by-height/submissions/734037718/
 * solved: 2022-06-29
 */
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> list = new LinkedList<>();

        // sort by height first, and then sort by position k
        Arrays.sort(people, (a, b)
                    -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        for (int[] p : people) {
            // insert into kth position starting from the tallest person
            list.add(p[1], p);
        }

        return list.toArray(new int[list.size()][]);
    }
}
