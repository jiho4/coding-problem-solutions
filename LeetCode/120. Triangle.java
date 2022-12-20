package leetcode;

import java.util.*;

/**
 * 120. Triangle
 * https://leetcode.com/problems/triangle/submissions/721136841/
 * solved: 2022-06-13
 */
// *bottom up approach*
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() > 1) {
            for (int level = triangle.size() - 2; level >= 0; level--) {
                for (int i = 0; i <= level; i++) {
                    int minSum =
                        triangle.get(level).get(i)
                        + Math.min(triangle.get(level+1).get(i)
                                   ,triangle.get(level+1).get(i+1));

                    // update value
                    triangle.get(level).set(i, minSum);
                }
            }
        } else {}

        return triangle.get(0).get(0);
    }
}

///////////////////////
// *top down optimized*
// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int minPath = Integer.MAX_VALUE;

//         for (int level = 1; level < triangle.size(); level++) {
//             for (int i = 0; i <= level; i++) {
//                 int minSum;
//                 int current = triangle.get(level).get(i);

//                 if (i == 0) {
//                     minSum = current
//                         + triangle.get(level - 1).get(i);
//                 } else if (i < level) {
//                     minSum = current
//                         + Math.min(triangle.get(level - 1).get(i - 1)
//                                   ,triangle.get(level - 1).get(i));
//                 } else { // i == level
//                     minSum = current
//                         + triangle.get(level - 1).get(i - 1);
//                 }

//                 triangle.get(level).set(i, minSum);
//             }
//         }

//         for (Integer value : triangle.get(triangle.size() - 1)) {
//             minPath = Math.min(minPath, value);
//         }

//         return minPath;
//     }
// }

////////////////////////////
// *top down with recursive*
// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         List<List<Integer>> memory = new ArrayList<List<Integer>>();
//         int minPath = Integer.MAX_VALUE;

//         memorize(triangle, memory, triangle.size() - 1);

//         for (Integer value : memory.get(memory.size() - 1)) {
//             minPath = Math.min(minPath, value);
//         }

//         return minPath;
//     }

//     private void memorize(List<List<Integer>> triangle
//                           ,List<List<Integer>> memory
//                           ,int level) {
//         if (level == 0) {
//             memory.add(
//                 new ArrayList<Integer>(
//                     new ArrayList<Integer>(
//                         List.of(triangle.get(0).get(0)))));
//         } else {
//             memorize(triangle, memory, level - 1);

//             List<Integer> sumRow = new ArrayList<Integer>();

//             for (int i = 0; i <= level; i++) {
//                 int current = triangle.get(level).get(i);

//                 if (i == 0) {
//                     sumRow.add(current + memory.get(level- 1).get(i));
//                 } else if (i < level) {
//                     int upperLeft = memory.get(level - 1).get(i - 1);
//                     int upperRight = memory.get(level - 1).get(i);

//                     sumRow.add(current + Math.min(upperLeft, upperRight));
//                 } else { // i == level
//                     sumRow.add(current + memory.get(level - 1).get(i - 1));
//                 }
//             }

//             memory.add(sumRow);
//         }
//     }
// }
