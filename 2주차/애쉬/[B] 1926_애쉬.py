# [B] 1926 (그림)
# boj.kr/1926

import sys
from collections import deque

input = sys.stdin.readline

n, m = map(int, input().split())
graph = []

for _ in range(n):
    graph.append(list(map(int, input().split())))

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

count = 0
_max = 0


def bfs(x, y):
    q = deque()
    q.append((x, y))
    size = 1
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] == 1:
                q.append((nx, ny))
                graph[nx][ny] = 0
                size += 1
    return size


for x in range(n):
    for y in range(m):
        if graph[x][y] == 1:
            graph[x][y] = 0
            count += 1
            size = bfs(x, y)
            _max = max(_max, size)

print(count)
print(_max)
