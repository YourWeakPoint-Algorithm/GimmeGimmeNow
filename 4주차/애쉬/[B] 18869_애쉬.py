# [B] 18869 (멀티버스 Ⅱ)
# boj.kr/18869

import sys
from bisect import bisect_left

input = sys.stdin.readline

m,n = map(int, input().split())

def solve(lst):
    sorted_lst = sorted(lst)
    result = []
    for target in lst:
        result.append(bisect_left(sorted_lst, target))
    return result

seq = []

for _ in range(m):
    lst = list(map(int, input().split()))
    seq.append(solve(lst))

count = 0
for i in range(len(seq)):
    for j in range(i+1, len(seq)):
        if seq[i] == seq[j]:
            count += 1

print(count)