# [B] 2467 (용액)
# boj.kr/2467

import sys

INF = int(1e10)

input = sys.stdin.readline
n = int(input())
lst = list(map(int,input().split()))

close = (INF, (-1,-1))

start = 0
end = len(lst) - 1
_min = INF
answer = (-1,-1)

while start < end:
    count = lst[start] + lst[end]
    if abs(count) < _min:
        answer = (lst[start], lst[end])
        _min = abs(count)
    
    if count < 0:
        start += 1
    else:
        end -= 1

print(*answer)