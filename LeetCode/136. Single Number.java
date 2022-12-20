package leetcode;

import java.util.*;

/**
 * 136. Single Number
 * https://leetcode.com/problems/single-number/submissions/710318889/
 * solved: 2022-05-30
 */
class Solution {
    public int singleNumber(int[] nums) {
        int ans = Integer.MIN_VALUE;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i+1]) {
                ans = nums[i];
                break;
            } else {}
        }

        if (ans == Integer.MIN_VALUE) {
            ans = nums[nums.length - 1];
        }

        return ans;
    }
}

// first try
// class Solution {
//     public int singleNumber(int[] nums) {
//         List<Integer> arr = new ArrayList<Integer>();

//         for (int n : nums) {
//             if (arr.contains(n)) {
//                 arr.remove(Integer.valueOf(n));
//             } else {
//                 arr.add(n);
//             }
//         }

//         return arr.get(0);
//     }
// }
