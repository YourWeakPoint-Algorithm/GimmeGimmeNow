# 23/06/16 애쉬
# [P] 게임 맵 최단거리
# https://school.programmers.co.kr/learn/courses/30/lessons/1844

from collections import deque


def solution(maps):
    dx = [1,-1,0,0]
    dy = [0,0,1,-1]
    
    n = len(maps)
    m = len(maps[0])

    q = deque([(0,0)])
        
    while q:
        x,y = q.popleft()
        if (x,y) == (n-1, m-1):
            return maps[x][y]
    
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            if maps[nx][ny] != 1:
                continue
            maps[nx][ny] = maps[x][y] + 1
            q.append((nx,ny))
    
    return -1
            