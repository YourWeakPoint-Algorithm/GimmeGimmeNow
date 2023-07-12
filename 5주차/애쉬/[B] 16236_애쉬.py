# [B] 16236 (아기 상어)
# boj.kr/16236

import heapq
import sys

input = sys.stdin.readline

n = int(input())

_map = []

for _ in range(n):
    lst = list(map(int,input().split()))
    _map.append(lst)

now = (0,0)
for i in range(len(_map)):
    for j in range(len(_map[i])):
        if _map[i][j] == 9:
            now = (i,j)

_map[now[0]][now[1]] = 0
dx = [-1,0,0,1]
dy = [0,-1,1,0]

now_size = 2


def eat_or_move():
    global now
    q = []
    heapq.heappush(q, (0,now))
    visited = [[False] * n for _ in range(n)]
    visited[now[0]][now[1]] = True
    while q:
        cost, tmp = heapq.heappop(q)
        x,y = tmp
        if _map[x][y] != 9:
            if now_size < _map[x][y]:
                continue
            if _map[x][y] < now_size and _map[x][y] != 0:
                now = (x,y)
                _map[x][y] = 0
                return cost
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if not(0<=nx<n) or not(0<=ny<n):
                continue
            if now_size < _map[nx][ny] or visited[nx][ny]:
                continue
            visited[nx][ny] = True
            heapq.heappush(q, (cost+1, (nx,ny)))
    return -1

count = 0
second = 0

while True:
    cost = eat_or_move()
    if cost == -1:
        break
    count += 1
    second += cost
    if count == now_size:
        now_size += 1
        count = 0
    if _map == [[0] * n for _ in range(n)]:
        break

print(second)