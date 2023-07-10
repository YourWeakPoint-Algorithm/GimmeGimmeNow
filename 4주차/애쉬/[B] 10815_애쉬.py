# [B] 10815 (숫자 카드)
# boj.kr/10815

import bisect
import sys

input = sys.stdin.readline

n = int(input())
lst = list(map(int, input().split()))
lst.sort()
m = int(input())
targets = list(map(int,input().split()))

def solve(lst, target):
    return bisect.bisect_right(lst,target) - bisect.bisect_left(lst,target)

for target in targets:
    print(solve(lst,target), end = " ")
