#
# @lc app=leetcode id=674 lang=python3
#
# [674] Longest Continuous Increasing Subsequence
#

# @lc code=start
from typing import List


class Solution:
    def findLengthOfLCIS(self, nums: List[int]) -> int:
        increment = -1
        length = [1]
        for i in range(0,len(nums)-1):
            if nums[i] < nums[i+1] and increment > 0:
                length[-1] += 1
            else:
                increment = nums[i+1] - nums[i]
                if increment <= 0:
                     continue
                length.append(2)
        return max(length)

        
# @lc code=end
