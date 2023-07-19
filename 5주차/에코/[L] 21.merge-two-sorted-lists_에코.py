#
# @lc app=leetcode id=21 lang=python3
#
# [21] Merge Two Sorted Lists
#

# @lc code=start
# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        answer = []
        left = list1
        right = list2
        while not(left == None and right == None):
            if (left == None or right == None):
                small = left if right == None else right
            else:
                small = left if left.val <= right.val else right
            answer.append(small.val)
            if right and small.val == right.val:
                right = right.next
            else:
                left = left.next
        return build_list_node(answer)

def build_list_node(arr):
    if not len(arr):
        return None
    temp_list = ListNode()
    list1 = temp_list
    for i in range(0,len(arr)): # 443211
        list1.val = arr[i]
        if not i == len(arr)-1:
            list1.next = ListNode()
            list1 = list1.next
    return temp_list
        
        
# @lc code=end

