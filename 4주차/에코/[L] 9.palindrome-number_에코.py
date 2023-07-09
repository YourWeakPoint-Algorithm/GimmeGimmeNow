#
# @lc app=leetcode id=9 lang=python3
#
# [9] Palindrome Number
#

# @lc code=start
class Solution:
    def isPalindrome(self, x: int) -> bool:
        string = str(x)
        for i in range(0,len(string)//2):
            if string[i] != string[len(string) - i - 1]:
                return False
        return True



        
# @lc code=end

