# [B] 1238 (파티)
# boj.kr/1238

import heapq
import sys

input = sys.stdin.readline
INF = int(1e9)

n,m,x = map(int, input().split())

graph_x = [[] for i in range(n+1)]
graph_y = [[] for i in range(n+1)]
distance_x = [INF] * (n+1)
distance_y = [INF] * (n+1)

for _ in range(m):
    a,b,t = map(int, input().split())
    graph_x[a].append((b,t))
    graph_y[b].append((a,t))

def dijkstra(start, graph, distance):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q:
        cost, now = heapq.heappop(q)
        if distance[now] < cost:
            continue
        for i in graph[now]:
            dest, time = i
            if cost + time < distance[dest]:
                distance[dest] = cost + time
                heapq.heappush(q, (cost+time, dest))

dijkstra(x, graph_x, distance_x)
dijkstra(x, graph_y, distance_y)

distance = [INF] * (n+1)
for i in range(n+1):
    distance[i] = distance_x[i] + distance_y[i]

print(max(distance[1:]))
