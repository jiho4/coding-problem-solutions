package leetcode;

import java.util.*;

/**
 * 2244. Minimum Rounds to Complete All Tasks
 * https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/submissions/871308176/
 * solved: 2023-01-04
 */
class Solution {
    public int minimumRounds(int[] tasks) {
        if (tasks.length == 1) {
            return -1;
        }

        Arrays.sort(tasks);

        int index = 0;
        int rounds = 0;

        while (index < tasks.length) {
            int count = 1;

            while (index + count < tasks.length
                && tasks[index] == tasks[index + count]) {
                count++;
            }

            if (count == 1) {
                rounds = -1;
                break;
            } else if (count % 3 == 0) {
                rounds += count / 3;
            } else { // count % 3 == 1 or 2
                rounds += count / 3 + 1;
            }

            index += count;
        }

        return rounds;
    }
}
