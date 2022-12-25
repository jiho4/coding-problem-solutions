/**
 * 2389. Longest Subsequence With Limited Sum
 * https://leetcode.com/problems/longest-subsequence-with-limited-sum/submissions/865150194/
 * solved: 2022-12-25
 */
function answerQueries(nums: number[], queries: number[]): number[] {
    const ans: number[] = []
    const cache = new Map<number, number>()

    // change nums into prefix sum array
    // index of nums + 1 == longest subseq of that sum
    nums.sort((a, b) =>  a - b)
    for (let i = 1; i < nums.length; i++) {
        nums[i] += nums[i-1]
    }

    for (let query of queries) {
        if (cache.has(query)) {
            ans.push(cache.get(query)!)
        } else {
            const maxSubseq = findMaxSubsequnece(nums, query)
            cache.set(query, maxSubseq)
            ans.push(maxSubseq)
        }
    }

    return ans
};

function findMaxSubsequnece(nums: number[], query: number): number {
    let left = 0
    let right = nums.length - 1

    // find with binary search
    while (left < right) {
        let mid = Math.floor((left + right) / 2)

        if (nums[mid] == query) {
            return mid + 1
        } else if (nums[mid] < query) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    return nums[left] > query ? left : left + 1
};
