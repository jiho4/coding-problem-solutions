package leetcode;

/**
 * 27. Remove Element
 * https://leetcode.com/problems/remove-element/submissions/706151086/
 * solved: 2022-05-24
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        int occurrence = 0;
        int sizeAfterRemoval = 0;

        for (int i = 0; i < nums.length; i++) {
            if (val == nums[i]) {
                occurrence++;
            } else {
                nums[i - occurrence] = nums[i];
                sizeAfterRemoval++;
            }
        }

        return sizeAfterRemoval;
    }
}
