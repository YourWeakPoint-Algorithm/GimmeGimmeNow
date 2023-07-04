# [B] 1654 (랜선 자르기)
# boj.kr/1654

import sys

input = sys.stdin.readline

k,n = map(int, input().split())
lst = []
for _ in range(k):
    lst.append(int(input()))

lst.sort()

_max = lst[len(lst)-1]

start = 1
end = _max
while start < end:
    mid = (start + end + 1) // 2
    count = 0
    for i in lst:
        count += i // mid
    if count >= n:
        start = mid
    else:
        end = mid - 1
print(start)
