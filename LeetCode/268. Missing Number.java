package leetcode;

/**
 * 268. Missing Number
 * https://leetcode.com/problems/missing-number/submissions/709007386/
 * solved: 2022-05-28
 */
class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int length = nums.length;

        for (int n : nums) {
            sum += n;
        }

        return length*(length+1) / 2 - sum;
    }
}

// first try
// class Solution {
//     public int missingNumber(int[] nums) {
//         int missingNum = 0;

//         Arrays.sort(nums);

//         for (int i = 0; i < nums.length; i++) {
//             if (i != nums[i]) {
//                 missingNum = i;
//                 break;
//             } else if (i == nums.length - 1 && missingNum == 0) {
//                 missingNum = nums.length;
//             } else {}
//         }

//         return missingNum;
//     }
// }
