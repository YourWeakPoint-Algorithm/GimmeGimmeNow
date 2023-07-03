# [B] 2295 (세 수의 합)
# boj.kr/2295

import sys
from bisect import bisect_left

input = sys.stdin.readline

n = int(input())
lst = []
for _ in range(n):
    lst.append(int(input()))

lst.sort()

two = set()
for i in range(len(lst)):
    for j in range(len(lst)):
        two.add(lst[i] + lst[j])

def result():
    for i in range(n-1, -1, -1):
        for j in range(i+1):
            if lst[i]-lst[j] in two:
                print(lst[i])
                return

result()