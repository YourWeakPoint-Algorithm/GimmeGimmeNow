# [B] 11052 (카드 구매하기)
# boj.kr/11052

import sys

input=sys.stdin.readline

n = int(input())
lst = [0]
lst += list(map(int, input().split()))

price = [0 for _ in range(n+1)]

price[1] = lst[1]

for i in range(2,n+1):
    tmp = 0
    for j in range(1, i//2+1):
        tmp = max(tmp, price[j] + price[i-j])
    if i % 2 == 0:
        tmp = max(tmp, price[i//2] * 2)
    tmp = max(tmp, lst[i])
    price[i] = tmp

print(price[n])