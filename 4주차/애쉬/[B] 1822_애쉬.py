# [B] 1822 (차집합)
# boj.kr/1822

import sys
from bisect import bisect_left, bisect_right

input= sys.stdin.readline

na, nb = map(int, input().split())

lst_a = list(map(int, input().split()))
lst_b = list(map(int, input().split()))

lst_a.sort()
lst_b.sort()

def solve(lst, target):
    return bisect_right(lst,target) == bisect_left(lst,target)

result = []
for target in lst_a:
    if solve(lst_b,target):
        result.append(target)

print(len(result))
for i in result:
    print(i, end = " ")