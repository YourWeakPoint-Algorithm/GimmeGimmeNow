# 23/06/16 애쉬
# [P] 네트워크
# https://school.programmers.co.kr/learn/courses/30/lessons/43162

def dfs(n, computers, visited):
    visited[n] = True
    _lst = computers[n]
    for i in range(len(_lst)):
        if i == n:
            continue
        if not visited[i] and _lst[i] == 1:
            dfs(i, computers, visited)
            
    
    
def solution(n, computers):
    visited = [False] * n
    count = 0
    for i in range(n):
        if not visited[i]:
            count += 1
            dfs(i, computers, visited)
    return count