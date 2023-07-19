#
# @lc app=leetcode id=13 lang=python3
#
# [13] Roman to Integer
#

# @lc code=start

SYMBOLS = {'I':1,'V':5,'X':10,'L':50,'C':100,'D':500,'M':1000}
class Solution:
    def romanToInt(self, s: str) -> int:
        num = 0
        for i in range(len(s)-1):
            if SYMBOLS[s[i]] < SYMBOLS[s[i+1]]:
                num -= SYMBOLS[s[i]]
            else:
                num += SYMBOLS[s[i]]
        num += SYMBOLS[s[len(s)-1]]

        return num


# @lc code=end

