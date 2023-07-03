# [B] 10816 (숫자 카드 2)
# boj.kr/10816

import sys

input = sys.stdin.readline
INF = int(1e9)

n = int(input())
lst = list(map(int,input().split()))
lst.sort()

m = int(input())
targets = list(map(int, input().split()))

# [-10, -10, 2, 3, 3, 6, 7, 10, 10, 10]

def find_start(lst, target):
    start = 0
    end = len(lst)
    while start < end:
        mid = (start + end) // 2
        if lst[mid] < target:
            start = mid + 1
        else:
            end = mid
    return start

def find_end(lst, target):
    start = 0
    end = len(lst)
    while start<end:
        mid = (start + end) // 2
        if lst[mid] <= target:
            start = mid + 1
        else:
            end = mid
    return start

for target in targets:
    start = find_start(lst, target)
    end = find_end(lst, target)
    print(end-start, end= " ")