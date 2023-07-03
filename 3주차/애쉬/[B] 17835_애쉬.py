# [B] 17835 (면접보는 승범이네)
# boj.kr/17835

import heapq
import sys

input = sys.stdin.readline
INF = int(1e10)

n,m,k = map(int, input().split())

graph = [[] for _ in range(n+1)]

for _ in range(m):
    u,v,c = map(int,input().split())
    graph[v].append((u,c))

locations = list(map(int,input().split()))

# 우선순위 q에 여러개 넣어도 되는 경우도 있음! (이건 그렇게 됐음.)
def dijkstra(locations, distance):
    q = []
    for i in locations:
        distance[i] = 0
        heapq.heappush(q, (0,i))
    while q:
        cost, now = heapq.heappop(q)
        if distance[now] < cost:
            continue
        for i in graph[now]:
            dest, dist = i
            if cost + dist < distance[dest]:
                distance[dest] = cost+dist
                heapq.heappush(q, (cost+dist, dest))

distance = [INF for _ in range(n+1)]

dijkstra(locations, distance)

_max = -1
max_i = -1
for i in range(1,n+1):
    if distance[i] > _max:
        _max = distance[i]
        max_i = i

print(max_i)
print(_max)
