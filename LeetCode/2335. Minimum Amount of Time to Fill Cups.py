from typing import List

# 2335. Minimum Amount of Time to Fill Cups
# https://leetcode.com/problems/minimum-amount-of-time-to-fill-cups/submissions/866616073/
# solved: 2022-12-27
class Solution:
    def fillCups(self, amount: List[int]) -> int:
        seconds = 0

        amount.sort()

        # if one cup reaches to full,
        # return current seconds + remaining max cup
        while amount[0] != 0:
            amount[0] -= 1
            amount[2] -= 1
            seconds += 1

            amount.sort()

        return seconds + amount[2]
