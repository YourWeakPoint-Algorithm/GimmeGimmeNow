# [B] 2206 (벽 부수고 이동하기)
# boj.kr/2206

import sys
from collections import deque

input = sys.stdin.readline

n,m = map(int, input().split())
graph = []
visited = [[[0] * 2 for _ in range(m)] for _ in range(n)]
lib = {False: 0, True: 1}
dx = [1,-1,0,0]
dy = [0,0,1,-1]

for _ in range(n):
    graph.append(list(map(int, input().strip())))

q = deque()
broken = graph[0][0] != 0
visited[0][0][lib[broken]] = 1
q.append((0,0,broken))

while q:
    x,y,broken = q.popleft()
    now = visited[x][y][lib[broken]]
    if (x,y) == (n-1,m-1):
        break
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if not((0<=nx<n) and (0<=ny<m)) or visited[nx][ny][lib[broken]] != 0:
            continue
        tmp_broken = broken
        if broken == True:
            if graph[nx][ny] != 0:
                continue
        else:
            tmp_broken = graph[nx][ny] != 0
        visited[nx][ny][lib[tmp_broken]] = now + 1
        q.append((nx,ny,tmp_broken))

answer = max(visited[n-1][m-1][0], visited[n-1][m-1][1])
if answer == 0:
    print(-1)
else:
    print(answer)