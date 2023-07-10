# [B] 16401 (과자 나눠주기)
# boj.kr/16401

import sys
from bisect import bisect_left, bisect_right

input = sys.stdin.readline

m, n = map(int, input().split())
lst = list(map(int, input().split()))
lst.sort()

start = 1
end = max(lst)
result = 0

while start <= end:
    mid = (start+end) //2
    if mid == 0:
        break
    count = 0
    for i in lst:
        count += i // mid
    if count >= m:
        start = mid + 1
        result = mid
    else:
        end = mid - 1

print(result)