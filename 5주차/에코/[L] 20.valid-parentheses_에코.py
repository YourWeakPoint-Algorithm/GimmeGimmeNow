#
# @lc app=leetcode id=20 lang=python3
#
# [20] Valid Parentheses
#

# @lc code=start
CLOSE = {")":"(","}":"{","]":"["}
class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for l in s:
            if l in ["(","[","{"]:
                stack.append(l)
            else:
                if not len(stack):
                    return False
                if stack[-1] == CLOSE[l]:
                    stack.pop()
                    continue
                return False
        if len(stack):
            return False
        else:
            return True
        
# @lc code=end

