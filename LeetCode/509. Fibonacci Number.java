package leetcode;

/**
 * 509. Fibonacci Number
 * https://leetcode.com/problems/fibonacci-number/submissions/739690982/
 * solved: 2022-07-05
 */
class Solution {
    public int fib(int n) {
        int[] mem = new int[n + 1];

        return calculateFib(n, mem);
    }

    private int calculateFib(int n, int[] mem) {
        if (n < 2) {
            return n;
        } else {
            if (mem[n] == 0) {
                mem[n] = calculateFib(n - 1, mem) + calculateFib(n - 2, mem);
            } else {}

            return mem[n];
        }
    }
}

// first try
// class Solution {
//     public int fib(int n) {
//         int res;

//         if (n == 0) {
//             res = 0;
//         } else if (n == 1) {
//             res = 1;
//         } else {
//             res = fib(n - 1) + fib(n - 2);
//         }

//         return res;
//     }
// }
