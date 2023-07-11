# [B] 11053 (가장 긴 증가하는  부분 수열)
# boj.kr/11053

import sys

input = sys.stdin.readline

n = int(input())
lst = list(map(int, input().split()))

dp = [0 for _ in range(n)]

dp[0] = 1

for i in range(1,len(lst)):
    dp[i] = 1
    for j in range(i-1, -1, -1):
        if lst[j] < lst[i]:
            dp[i] = max(dp[i], dp[j] + 1)

print(max(dp))