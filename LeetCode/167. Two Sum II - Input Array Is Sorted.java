package leetcode;

/**
 * 167. Two Sum II - Input Array Is Sorted
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/submissions/717923945/
 * solved: 2022-06-09
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                ans[0] = left + 1;
                ans[1] = right + 1;
                break;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return ans;
    }
}

// first try
// class Solution {
//     public int[] twoSum(int[] numbers, int target) {
//         int[] ans = {0, 0};

//         for (int i = numbers.length - 1; i > 0; i--) {
//             for (int j = 0; j < i; j++) {
//                 if (numbers[i] + numbers[j] > target) {
//                     break;
//                 } else if (numbers[i] + numbers[j] == target) {
//                     ans[0] = j + 1;
//                     ans[1] = i + 1;
//                     break;
//                 } else {}
//             }

//             if (ans[0] + ans[1] != 0) {
//                 break;
//             } else {}
//         }

//         return ans;
//     }
// }
