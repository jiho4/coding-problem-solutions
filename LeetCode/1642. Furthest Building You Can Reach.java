package leetcode;

import java.util.*;

/**
 * 1642. Furthest Building You Can Reach
 * https://leetcode.com/problems/furthest-building-you-can-reach/submissions/727444975/
 * solved: 2022-06-21
 */
class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> priorityQueueLowest = new PriorityQueue<>();
        int distance = 0;

        for (int i = 0; i < heights.length; i++) {

            // it reached the final building
            if (i == heights.length - 1) {
                distance = i;
                break;
            // height of the next building is equal or small
            } else if (heights[i] >= heights[i + 1]) {
                distance = i;
                continue;
            } else {
                priorityQueueLowest.add(heights[i + 1] - heights[i]);

                // use ladder first, then use bricks
                if (ladders > 0) {
                    ladders--;
                // use bricks instead of ladder for the lowest difference of height
                } else if (bricks >= 0) {
                    bricks -= priorityQueueLowest.poll();
                } else {}

                // cannot go further more
                if (bricks < 0) {
                    distance = i;
                    break;
                } else {}
            }
        }

        return distance;
    }
}

// simple recursive solution. timed out
// class Solution {
//     public int furthestBuilding(int[] heights, int bricks, int ladders) {
//         return goNextBuilding(heights, 0, bricks, ladders);
//     }

//     private int goNextBuilding(int[] heights, int i, int bricks, int ladders) {
//         int nextHeight;
//         int ladderCase = 0;
//         int brickCase = 0;

//         if (i == heights.length - 1) {
//             // it reached the final building
//             return i;
//         } else if (heights[i] >= heights[i + 1] ) {
//             // height of the next building is equal or small
//             return goNextBuilding(heights, i + 1, bricks, ladders);
//         } else {
//             nextHeight = heights[i + 1] - heights[i];

//             if (ladders == 0 && nextHeight > bricks) {
//                 // cannot go further more
//                 return i;
//             }  else {
//                 // try to use a ladder
//                 if (ladders > 0) {
//                     ladderCase = goNextBuilding(heights, i + 1, bricks, ladders - 1);
//                 } else {}

//                 // try to use bricks
//                 if (bricks > nextHeight) {
//                     brickCase = goNextBuilding(heights
//                                                , i + 1, bricks - nextHeight
//                                                , ladders);
//                 } else {}

//                 return Math.max(ladderCase, brickCase);
//             }
//         }
//     }
// }
