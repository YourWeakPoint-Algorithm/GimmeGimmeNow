# [B] 1504 (특정한 최단 경로)
# boj.kr/1238

import heapq
import sys

input = sys.stdin.readline
INF = int(1e9)

n,e = map(int, input().split())
graph = [[] for _ in range(n+1)]
distance_1 = [INF] * (n+1)
distance_v1 = [INF] * (n+1)
distance_v2 = [INF] * (n+1)

for _ in range(e):
    a,b,c = map(int, input().split())
    graph[a].append((b,c))
    graph[b].append((a,c))

v1,v2 = map(int, input().split())

# 1 -> v1 -> v2 -> n
# 1 -> v2 -> v1 -> n

def dijkstra(start, distance):
    q = []
    distance[start] = 0
    heapq.heappush(q, (0, start))
    while q:
        cost, now = heapq.heappop(q)
        if distance[now] < cost:
            continue
        for i in graph[now]:
            dest, dist = i
            if cost + dist < distance[dest]:
                distance[dest] = cost + dist
                heapq.heappush(q, (cost+dist, dest))

dijkstra(1, distance_1)
dijkstra(v1, distance_v1)
dijkstra(v2, distance_v2)

a = distance_1[v1] + distance_v1[v2] + distance_v2[n]
b = distance_1[v2] + distance_v2[v1] + distance_v1[n]

dist = min(a,b)
if dist >= INF:
    print(-1)
else:
    print(dist)

