# [B] 10026 (적록색약)
# boj.kr/10026

import sys
from collections import deque

input = sys.stdin.readline

yes = {"R": 0, "G": 0, "B": 1}
no = {"R":0, "G":1, "B":2}
n = int(input())
graph = []
for _ in range(n):
    graph.append(list(input().strip()))

dx = [1,-1,0,0]
dy = [0,0,1,-1]

visited = {True: [[False] * n for _ in range(n)], False: [[False] * n for _ in range(n)]}

def get_color(weak, color):
    if weak:
        return yes[color]
    return no[color]

def bfs(x,y,weak):
    visited[weak][x][y] = True
    q = deque()
    q.append((x,y))
    while q:
        x,y = q.popleft()
        past = get_color(weak, graph[x][y])
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if not((0<=nx<n) and (0<=ny<n)) or visited[weak][nx][ny] == True:
                continue
            now = get_color(weak, graph[nx][ny])
            if past == now:
                visited[weak][nx][ny] = True
                q.append((nx,ny))


def check(weak):
    count = 0
    for x in range(n):
        for y in range(n):
            if not visited[weak][x][y]:
                bfs(x,y,weak)
                count += 1
    return count

print(check(False), check(True))
