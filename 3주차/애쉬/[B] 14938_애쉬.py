# [B] 14938 (서강그라운드)
# boj.kr/14938

import sys

input = sys.stdin.readline
INF = int(1e9)

n,m,r = map(int,input().split())
items = [0]
items += list(map(int,input().split()))

distance = [[INF] * (n+1) for _ in range(n+1)]

for i in range(1,n+1):
    distance[i][i] = 0

for _ in range(r):
    a,b,c = map(int,input().split())
    distance[a][b] = c
    distance[b][a] = c

for k in range(1,n+1):
    for x in range(1,n+1):
        for y in range(1,n+1):
            distance[x][y] = min(distance[x][y], distance[x][k] + distance[k][y])

result = 0 
for i in range(1,n+1):
    item_count = 0
    for j in range(1,n+1):
        if distance[i][j] <= m:
            item_count += items[j]
    result = max(result, item_count)

print(result)