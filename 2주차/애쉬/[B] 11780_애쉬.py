# [B] 11780 (플로이드2)
# boj.kr/11780

import sys

input = sys.stdin.readline
INF = int(1e9)

n = int(input())
m = int(input())

graph = [[INF] * (n+1) for _ in range(n+1)]
nxt = [[0] * (n+1) for _ in range(n+1)]

for i in range(1,n+1):
    graph[i][i] = 0

for _ in range(m):
    a,b,c = map(int,input().split())
    graph[a][b] = min(c, graph[a][b])
    nxt[a][b] = b

for k in range(1,n+1):
    for a in range(1,n+1):
        for b in range(1,n+1):
            if graph[a][k] + graph[k][b] < graph[a][b]:
                nxt[a][b] = nxt[a][k]
                graph[a][b] = graph[a][k] + graph[k][b]

for a in range(1,n+1):
    for b in range(1,n+1):
        c = graph[a][b]
        if c == INF:
            c = 0
        print(c, end= " ")
    print()

for a in range(1,n+1):
    for b in range(1,n+1):
        _lst = []
        if nxt[a][b] == 0:
            print(0)
            continue
        x,y = a,b
        _lst.append(x)
        while True:
            x = nxt[x][y]
            _lst.append(x)
            if x == y:
                break
        print(len(_lst), end = " ")
        print(*_lst)
