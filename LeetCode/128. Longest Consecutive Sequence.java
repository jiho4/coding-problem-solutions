package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 128. Longest Consecutive Sequence
 * https://leetcode.com/problems/longest-consecutive-sequence/submissions/738855193/
 * solved: 2022-07-05
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        // convert int array to Integer Set
        Set<Integer> numsSet = new HashSet<>(
            Arrays.stream(nums).boxed().collect(Collectors.toList()));

        int maxSequence = 0;

        // for each numbers
        for (Integer n : numsSet) {
            int sequence = 0;

            // if n-1 exists, then it is not the start of the sequence
            if (!numsSet.contains(n - 1)) {
                // check until the sequence breaks by incementing 1
                while(numsSet.contains(n)) {
                    sequence++;
                    n++;
                }

                maxSequence = Math.max(maxSequence, sequence);
            } else {
                continue;
            }
        }

        return maxSequence;
    }
}
