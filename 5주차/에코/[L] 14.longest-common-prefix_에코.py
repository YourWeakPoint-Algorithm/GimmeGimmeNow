#
# @lc app=leetcode id=14 lang=python3
#
# [14] Longest Common Prefix
#

# @lc code=start
from typing import List


class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if len(strs) == 0:
            return ""
        if len(strs) == 1:
            return strs[0]
        sub = find_sub(strs[0],strs[1])
        if not sub:
            return ""
        comp = sub
        for i in range(2,len(strs)):
            comp = find_sub(comp,strs[i])
            if len(comp) >= 1:
                continue
            else:
                comp = ""
                break
        if comp:
            return comp
        return ""
            
            
    


def find_sub(str1:str,str2:str):
    left = str1
    right = str2
    sub = ""
    target,comp = (right,left) if len(right) >= len(left) else (left,right)
    for i in range(0,len(comp)):
        if target[i] == comp[i]:
            sub += comp[i]
            continue
        else:
            break
    return sub



        
# @lc code=end

