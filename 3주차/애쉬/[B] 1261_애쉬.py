# [B] 1261 (알고스팟)
# boj.kr/1261

import heapq
import sys

input = sys.stdin.readline
INF = int(1e9)

m,n = map(int, input().split())

graph = []
distance = [[INF] * m for _ in range(n)]
dx = [1,-1,0,0]
dy = [0,0,1,-1]

for _ in range(n):
    _lst = list(map(int, input().strip()))
    graph.append(_lst)

# 0,0 -> (n-1), (m-1)

distance[0][0] = 0
q = []
heapq.heappush(q, (0, 0,0))
while q:
    cost, x, y = heapq.heappop(q)
    if (x,y) == (n-1,m-1):
        break
    if distance[x][y] < cost:
        continue
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if not((0<=nx<n) and (0<=ny<m)):
            continue
        if distance[nx][ny] != INF:
            continue
        distance[nx][ny] = cost + graph[nx][ny]
        heapq.heappush(q, (cost + graph[nx][ny], nx,ny))

print(distance[n-1][m-1])
        