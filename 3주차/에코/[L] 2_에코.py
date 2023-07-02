# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        value1 = self.parser(l1)
        value2 = self.parser(l2)
        total = value1 + value2
        return self.composer(total)

    def parser(self, list_node):
        total = ""
        while list_node:
            total = str(list_node.val) + total
            list_node = list_node.next
        return int(total)
    
    def composer(self, value):
        string_value = str(value) #807
        first_list_node = ListNode(string_value[-1])
        list_node = first_list_node
        for i in reversed(range(0,len(string_value)-1)):
            next_node = ListNode(string_value[i])
            list_node.next = next_node
            list_node = next_node
        return first_list_node