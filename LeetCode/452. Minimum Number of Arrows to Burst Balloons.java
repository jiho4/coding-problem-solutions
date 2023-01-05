package leetcode;

import java.util.*;

/**
 * 452. Minimum Number of Arrows to Burst Balloons
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/submissions/872180378/
 * solved: 2023-01-05
 */
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int arrow = points[0][1];
        int shotCount = 1;

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > arrow) {
                arrow = points[i][1];
                shotCount++;
            }
        }

        return shotCount;
    }
}
