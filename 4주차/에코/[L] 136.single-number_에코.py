from collections import Counter
class Solution:
    def singleNumber(self, nums):
        count = Counter(nums)
        one = list(filter(lambda x: count[x]==1,nums))
        return one[0]