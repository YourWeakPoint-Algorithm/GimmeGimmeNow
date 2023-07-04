# [B] 2805 (나무 자르기)
# boj.kr/2805

import sys

input = sys.stdin.readline

n,m = map(int, input().split())
lst = list(map(int, input().split()))
lst.sort()

start = 0
end = max(lst)
result = 0

while start <= end:
    mid = (start + end) // 2
    count = 0
    for i in lst:
        count += max(0, i - mid)
    if count >= m:
        result = mid
        start = mid + 1
    else:
        end = mid -1

print(result)