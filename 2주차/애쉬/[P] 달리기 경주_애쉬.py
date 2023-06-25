# [P] 달리기 경주
# https://school.programmers.co.kr/learn/courses/30/lessons/178871

def solution(players, callings):
    order = {}
    for i in range(len(players)):
        player = players[i]
        order[player] = i
    
    for name in callings:
        i = order[name]
        other = players[i-1]
        players[i-1], players[i] = players[i], players[i-1]
        order[name] = i-1
        order[other] = i
    
    return players