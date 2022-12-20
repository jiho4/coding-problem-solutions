package leetcode;

/**
 * 35. Search Insert Position
 * https://leetcode.com/problems/search-insert-position/submissions/738221390/
 * solved: 2022-07-04
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        return search(nums, target, 0, nums.length);
    }

    private int search(int[] nums, int target, int start, int end) {
        int index = (start + end) / 2;
        int ans = 0;


        if (nums[index] == target) {
            ans = index;
        // target is in the left side
        } else if (nums[index] > target) {
            if (index == 0) {
                ans = 0;
            } else if (nums[index - 1] < target) {
                ans = index;
            } else {
                ans = search(nums, target, start, index);
            }
        // target is in the right side
        } else { // nums[index] < target
            if (index == nums.length - 1) {
                ans = nums.length;
            } else if (nums[index + 1] > target) {
                ans = index + 1;
            } else {
                ans = search(nums, target, index, end);
            }
        }

        return ans;
    }
}
