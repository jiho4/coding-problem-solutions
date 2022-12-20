package leetcode;

/**
 * 88. Merge Sorted Array
 * https://leetcode.com/problems/merge-sorted-array/submissions/716599659/
 * solved: 2022-06-07
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m - 1;
        int tail2 = n - 1;
        int realTail = m + n - 1;

        while (tail2 >= 0) {
            if (tail1 >= 0 && nums1[tail1] > nums2[tail2]) {
                nums1[realTail] = nums1[tail1];
                tail1--;
            } else {
                nums1[realTail] = nums2[tail2];
                tail2--;
            }
            realTail--;
        }

        return;
    }
}
