# 23/06/16 애쉬
# [P] 타겟 넘버
# https://school.programmers.co.kr/learn/courses/30/lessons/43165

count = 0

def dfs(now, numbers, i, target):
    global count
    if len(numbers) <= i:
        return
    t = numbers[i]
    if len(numbers)-1 == i:
        if now + t == target or now -t == target:
            count += 1
    dfs(now+t, numbers, i+1, target)
    dfs(now-t, numbers, i+1, target)
    

def solution(numbers, target):
    dfs(0, numbers, 0, target)
    return count
