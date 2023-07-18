# [B] 16953 (A → B)
# boj.kr/16953

import sys

input = sys.stdin.readline

a,b = map(int, input().split())

count = 1

while a < b:
    count += 1
    if b % 10 == 1:
        b = b // 10
    elif b % 2 == 0:
        b = b // 2
    else:
        break

if a == b:
    print(count)
else:
    print(-1)
