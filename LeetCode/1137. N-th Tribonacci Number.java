package leetcode;

/**
 * 1137. N-th Tribonacci Number
 * https://leetcode.com/problems/n-th-tribonacci-number/submissions/560208531/
 * solved: 2021-09-24
 */
class Solution {
    int[] memory = new int[38];

    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            if (memory[n] == 0) {
                // save the result value of tribonacci[n], so that it can be reused
                memory[n] = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
            } else {}

            return memory[n];
        }
    }
}
