package leetcode;

/**
 * 1833. Maximum Ice Cream Bars
 * https://leetcode.com/problems/maximum-ice-cream-bars/submissions/872825468/
 * solved: 2023-01-06
 */
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int maxCost = 0;

        for (int cost : costs) {
            maxCost = Math.max(maxCost, cost);
        }

        int[] freqCosts = new int[maxCost + 1];

        // store the frequencies of each cost
        for (int cost : costs) {
            freqCosts[cost]++;
        }

        int sum = 0;
        int count = 0;

        for (int i = 1; i < freqCosts.length; i++) {
            if (sum + freqCosts[i]*i <= coins) {
                sum += freqCosts[i]*i;
                count += freqCosts[i];
            } else {
                count += (coins - sum) / i;
                break;
            }
        }

        return count;
    }
}

// *first try: basic sort solution
// class Solution {
//     public int maxIceCream(int[] costs, int coins) {
//         Arrays.sort(costs);

//         int sum = 0;
//         int count = 0;

//         for (int i = 0; i < costs.length; i++) {
//             if (sum + costs[i] <= coins) {
//                 sum += costs[i];
//                 count++;
//             } else {
//                 break;
//             }
//         }

//         return count;
//     }
// }
