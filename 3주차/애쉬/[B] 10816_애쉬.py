# [B] 10816 (숫자 카드 2)
# boj.kr/10816

import sys

input = sys.stdin.readline
INF = int(1e9)

n = int(input())
lst = list(map(int,input().split()))
lst.sort()

m = int(input())
targets = list(map(int, input().split()))

# [-10, -10, 2, 3, 3, 6, 7, 10, 10, 10]

# start_i 랑 end_i 를 구하면 될듯
def search(lst, target):
    start_target = INF
    end_target = -1

    # find start_target
    start = 0 
    end = len(lst)-1
    while start <= end:
        mid = (start + end) // 2
        if lst[mid] == target:
            if start_target > mid:
                start_target = mid
                end = mid - 1
        if lst[mid] < target:
            start = mid + 1
        else:
            end = mid - 1
    
    # find end_target
    start = 0 
    end = len(lst)-1
    while start <= end:
        mid = (start + end) // 2
        if lst[mid] == target:
            if end_target < mid:
                end_target = mid
                start = mid + 1
        elif lst[mid] < target:
            start = mid + 1
        else:
            end = mid - 1

    return (start_target, end_target)

for target in targets:
    start, end = search(lst, target)
    if start == INF:
        print(0, end = " ")
    else:
        print(end-start+1, end = " ")
