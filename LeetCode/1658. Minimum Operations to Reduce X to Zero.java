package leetcode;

/**
 * 1658. Minimum Operations to Reduce X to Zero
 * https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/submissions/719382988/
 * solved: 2022-06-11
 */
class Solution {
    public int minOperations(int[] nums, int x) {
        int totalSum = 0;
        int ans;

        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        if (totalSum < x) {
            ans = -1;
        } else if (totalSum == x) {
            ans = nums.length;
        } else {
            int target = totalSum - x;
            int left = 0;
            int window = 0;
            int sum = 0;

            for (int right = 0; right < nums.length; right++) {
                sum += nums[right];

                while (sum >= target) {
                    if (sum == target) {
                        window = Math.max(window, right - left + 1);
                    } else {}

                    sum -= nums[left];
                    left++;
                }
            }

            if (window == 0) {
                ans = -1;
            } else {
                ans = nums.length - window;
            }
        }

        return ans;
    }
}

// #time limit exceeded
// class Solution {
//     public int minOperations(int[] nums, int x) {
//         return operation(nums, 0, 0, nums.length - 1, x);
//     }

//     private int operation(int[] nums, int count, int left, int right, int x) {
//         if (x == 0) {
//             return count;
//         } else if (x < 0 || left > right) {
//             return -1;
//         } else if (nums[left] == x || nums[right] == x) {
//             return count + 1;
//         } else {
//             int leftResult = operation(nums, count + 1, left + 1, right, x - nums[left]);
//             int rightResult = operation(nums, count + 1, left, right - 1, x - nums[right]);

//             if (leftResult == -1 && rightResult == -1) {
//                 return -1;
//             } else if (leftResult == -1 || rightResult == -1) {
//                 return Math.max(leftResult, rightResult);
//             } else {
//                 return Math.min(leftResult, rightResult);
//             }
//         }
//     }
// }
