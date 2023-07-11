# [B] 2156 (포도주 시식)
# boj.kr/2156

import sys

input = sys.stdin.readline

# i i-1 dp[i-3]
# i dp[i-2]
# dp[i-1]

n = int(input())
lst = []
for _ in range(n):
    lst.append(int(input()))
lst += [0,0]

dp = [0 for i in range(n+2)]

dp[0] = lst[0]
dp[1] = lst[0] + lst[1]
dp[2] = max(lst[2] + lst[1] , dp[1], lst[2]  + lst[0])

for i in range(2, n):
    dp[i] = max(dp[i-1], lst[i]+dp[i-2], lst[i] + lst[i-1] + dp[i-3])

print(dp[n-1])