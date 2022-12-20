package leetcode;

/**
 * 922. Sort Array By Parity II
 * https://leetcode.com/problems/sort-array-by-parity-ii/submissions/562343091/
 * solved: 2021-09-28
 */
class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int evenRunner = 0;
        int oddRunner = 1;

        while (evenRunner < nums.length && oddRunner < nums.length) {
            while (evenRunner < nums.length && nums[evenRunner] % 2 == 0) {
                evenRunner += 2;
            }
            while (oddRunner < nums.length && nums[oddRunner] % 2 == 1) {
                oddRunner += 2;
            }

            if (evenRunner < nums.length && oddRunner < nums.length) {
                // swap
                int temp = nums[evenRunner];
                nums[evenRunner] = nums[oddRunner];
                nums[oddRunner] = temp;
            } else {}
        }

        return nums;
    }
}
