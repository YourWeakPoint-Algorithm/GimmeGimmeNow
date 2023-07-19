#
# @lc app=leetcode id=100 lang=python3
#
# [100] Same Tree
#

# @lc code=start
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
from typing import Optional


class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        return recursiveCheckTree(p,q)

def recursiveCheckTree(p:Optional[TreeNode],q:Optional[TreeNode]):
    if p == None and q == None:
        return True
    if not(p == None or q == None) and p.val == q.val:
        return recursiveCheckTree(p.left,q.left) and recursiveCheckTree(p.right,q.right)
    else:
        return False

        
# @lc code=end

